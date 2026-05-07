package com.kel4.minimarket911.component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ZoomImageLabel extends JLabel {

    // ===== IMAGE SETTINGS =====
    private boolean smoothRendering = true;

    // ===== ALIGNMENT =====
    private int imageHorizontalAlignment = CENTER;
    private int imageVerticalAlignment = CENTER;

    public ZoomImageLabel() {
        setOpaque(false);
        setText(null);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Icon originalIcon = getIcon();

        // cegah JLabel menggambar icon default
        setIcon(null);

        super.paintComponent(g);

        // kembalikan icon
        setIcon(originalIcon);

        if (originalIcon == null) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();

        if (smoothRendering) {

            g2.setRenderingHint(
                    RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR
            );

            g2.setRenderingHint(
                    RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY
            );

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
        }

        int componentWidth = getWidth();
        int componentHeight = getHeight();

        int iconWidth = originalIcon.getIconWidth();
        int iconHeight = originalIcon.getIconHeight();

        if (iconWidth <= 0 || iconHeight <= 0) {
            g2.dispose();
            return;
        }

        // ===== SCALE =====
        double scaleX = (double) componentWidth / iconWidth;
        double scaleY = (double) componentHeight / iconHeight;

        double scale = Math.max(scaleX, scaleY);

        int drawWidth = (int) (iconWidth * scale);
        int drawHeight = (int) (iconHeight * scale);

        // ===== POSITION =====
        int x = switch (imageHorizontalAlignment) {

            case LEFT ->
                0;
            case RIGHT ->
                componentWidth - drawWidth;
            default ->
                (componentWidth - drawWidth) / 2;
        };

        int y = switch (imageVerticalAlignment) {

            case TOP ->
                0;
            case BOTTOM ->
                componentHeight - drawHeight;
            default ->
                (componentHeight - drawHeight) / 2;
        };

        // ===== DRAW =====
        if (originalIcon instanceof ImageIcon imageIcon) {

            Image image = imageIcon.getImage();
            g2.setClip(0, 0, componentWidth, componentHeight);

            g2.drawImage(
                    image,
                    x,
                    y,
                    drawWidth,
                    drawHeight,
                    this
            );

        } else {

            originalIcon.paintIcon(this, g2, x, y);
        }

        g2.dispose();
    }

    // =================================
    // PROPERTIES
    // =================================
    public boolean isSmoothRendering() {
        return smoothRendering;
    }

    public void setSmoothRendering(boolean smoothRendering) {
        this.smoothRendering = smoothRendering;
        repaint();
    }

    public int getImageHorizontalAlignment() {
        return imageHorizontalAlignment;
    }

    public void setImageHorizontalAlignment(int imageHorizontalAlignment) {
        this.imageHorizontalAlignment = imageHorizontalAlignment;
        repaint();
    }

    public int getImageVerticalAlignment() {
        return imageVerticalAlignment;
    }

    public void setImageVerticalAlignment(int imageVerticalAlignment) {
        this.imageVerticalAlignment = imageVerticalAlignment;
        repaint();
    }
}
