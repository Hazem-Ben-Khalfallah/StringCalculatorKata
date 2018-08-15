package com.blacknebula.kata;

import org.assertj.core.util.Lists;

public class StringCalculator {

    /**
     * @should return zero if input is an empty string
     * @should return same value if one number is passed
     * @should return sum if two numbers are passed
     * @should return sum if any amount of numbers
     */
    public int add(String input) {
        if (input.length() == 0) {
            return 0;
        }
        final String[] numbers = input.split(",");
        return Lists.list(numbers).stream()
                .mapToInt(this::parseInt)
                .sum();
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

}
