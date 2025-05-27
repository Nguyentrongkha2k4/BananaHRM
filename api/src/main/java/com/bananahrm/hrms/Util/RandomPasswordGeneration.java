package com.bananahrm.hrms.Util;

import java.security.SecureRandom;

public class RandomPasswordGeneration {
   private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int DEFAULT_PASSWORD_LENGTH = 5;
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generate a random alphanumeric password with default length (5 characters)
     */
    public static String generateRandomPassword() {
        return generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
    }

    /**
     * Generate a random alphanumeric password with custom length
     * @param length desired password length
     * @return random password
     */
    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }
}
