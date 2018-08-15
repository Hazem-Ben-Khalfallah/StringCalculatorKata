package com.blacknebula.kata;

public class StringCalculator {

    /**
     * @should return zero if input is an empty string
     * @should return same value if one number is passed
     */
    public int add(String input) {
        if (input.length() == 0) {
            return 0;
        }

        return Integer.parseInt(input);
    }
}
