/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.utils;

import java.util.Random;

public class pwdUtil {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generatePassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }
        StringBuilder password = new StringBuilder(length);
        Random random = new Random();
        password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        for (int i = 4; i < length; ++i) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }
        char[] passwordChars = password.toString().toCharArray();
        for (int i = passwordChars.length - 1; i > 0; --i) {
            int index = random.nextInt(i + 1);
            char temp = passwordChars[i];
            passwordChars[i] = passwordChars[index];
            passwordChars[index] = temp;
        }
        return new String(passwordChars);
    }

    public static void main(String[] args) {
        int passwordLength = 16;
        String password = pwdUtil.generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }
}

