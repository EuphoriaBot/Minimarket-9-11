package com.kel4.minimarket911.component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CustomTextField extends JTextField {

    private int cornerRadius = 20;

    private String placeholder = "";
    private Color placeholderColor = new Color(150, 150, 150);

    // ===== ICON =====
    private Icon leadingIcon;
    private int iconSize = 18;
    private int iconTextGap = 8;

    private Color borderColor = new Color(200, 200, 200);
    private float borderThickness = 1.5f;

    public CustomTextField() {
        setOpaque(false);
        setBackground(Color.WHITE);
        updatePadding();
    }

    public CustomTextField(int columns) {
        super(columns);
        setOpaque(false);
        setBackground(Color.WHITE);
        updatePadding();
    }

    private void updatePadding() {

        int left = 12;

        if (leadingIcon != null) {

            left += iconSize + iconTextGap;
        }

        setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        left,
                        8,
                        12
                )
        );

        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int width = getWidth();
        int height = getHeight();

        // ===== BACKGROUND =====
        g2.setColor(getBackground());

        g2.fillRoundRect(
                0,
                0,
                width - 1,
                height - 1,
                cornerRadius,
                cornerRadius
        );

        // ===== ICON =====
        if (leadingIcon != null) {

            int x = 12;
            int y = (height - iconSize) / 2;

            try {

                // render icon ke buffer
                Image image;

                if (leadingIcon instanceof ImageIcon imageIcon) {

                    image = imageIcon.getImage();

                } else {
                    BufferedImage buffer = new BufferedImage(
                            leadingIcon.getIconWidth(),
                            leadingIcon.getIconHeight(),
                            BufferedImage.TYPE_INT_ARGB
                    );

                    Graphics2D bg = buffer.createGraphics();

                    leadingIcon.paintIcon(this, bg, 0, 0);

                    bg.dispose();

                    image = buffer;
                }

                // draw resized
                g2.drawImage(
                        image,
                        x,
                        y,
                        iconSize,
                        iconSize,
                        this
                );

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        g2.dispose();

        super.paintComponent(makeTransparent(g));

        // ===== PLACEHOLDER =====
        if (getText().isEmpty()
                && !isFocusOwner()
                && placeholder != null
                && !placeholder.isEmpty()) {

            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2d.setColor(placeholderColor);

            g2d.setFont(getFont().deriveFont(Font.ITALIC));

            Insets insets = getInsets();

            FontMetrics fm = g2d.getFontMetrics();

            int x = insets.left;

            int y = getHeight() / 2 + fm.getAscent() / 2 - 2;

            g2d.drawString(placeholder, x, y);

            g2d.dispose();
        }
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(borderColor);

        g2.setStroke(new BasicStroke(borderThickness));

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                cornerRadius,
                cornerRadius
        );

        g2.dispose();
    }

    // ===== PROPERTIES =====
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    public Color getPlaceholderColor() {
        return placeholderColor;
    }

    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
        repaint();
    }

    private Graphics makeTransparent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.SrcOver);
        return g2;
    }

    // ===== ICON PROPERTIES =====
    public Icon getLeadingIcon() {
        return leadingIcon;
    }

    public void setIcon(Icon leadingIcon) {
        this.leadingIcon = leadingIcon;
        updatePadding();
    }

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int iconSize) {
        this.iconSize = iconSize;
        updatePadding();
    }

    public int getIconTextGap() {
        return iconTextGap;
    }

    public void setIconTextGap(int iconTextGap) {
        this.iconTextGap = iconTextGap;
        updatePadding();
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    public float getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(float borderThickness) {
        this.borderThickness = borderThickness;
        repaint();
    }
}
