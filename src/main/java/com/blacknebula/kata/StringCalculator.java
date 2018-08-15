package com.blacknebula.kata;

public class StringCalculator {

    /**
     * @should return zero if input is an empty string
     * @should return same value if one number is passed
     * @should return sum if two numbers are passed
     */
    public int add(String input) {
        if (input.length() == 0) {
            return 0;
        }
        final String[] numbers = input.split(",");

        if (numbers.length == 1) {
            return parseInt(numbers[0]);
        }
        return parseInt(numbers[0]) + parseInt(numbers[1]);
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

}
