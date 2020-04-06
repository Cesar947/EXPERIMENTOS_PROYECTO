package com.myorg.ezdeal.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasena {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    }
}
