package com.example.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Component
public final class MD5Util {

    public static String encrypt(String strSrc) {
        try {
            // Create MD5 digest
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert string to bytes using UTF-8
            byte[] bytes = md.digest(strSrc.getBytes(StandardCharsets.UTF_8));

            // Convert bytes to hexadecimal string
            return HexFormat.of().formatHex(bytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 encryption failed", e);
        }
    }
}
