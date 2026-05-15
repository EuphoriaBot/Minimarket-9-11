package com.kel4.minimarket911;

import com.formdev.flatlaf.*;
import com.kel4.minimarket911.auth.FormLogin;

public class Main {
    public static void main() {
        FlatLightLaf.setup();
        FormLogin formLogin = new FormLogin();
        formLogin.setVisible(true);
    }
}

