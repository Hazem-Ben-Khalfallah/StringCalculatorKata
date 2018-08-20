package com.blacknebula.kata;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hazem
 */
public class StringCalculator {
    /**
     * @should return zero if an empty String is passed
     * @should return same number if a unique number is passed
     * @should return the sum of two numbers
     * @should return the sum of any amount of numbers
     * @should handle new lines between numbers
     * @should support a different delimiter
     * @should throw an exception if a negative has been added using default separators
     * @should throw an exception if a negative has been added using a custom separator
     * @should ignore numbers greater than 1000
     * @should return 0 if all numbers are greater than 1000
     */
    public int add(String text) {
        if (text.length() == 0) {
            return 0;
        }

        final List<Integer> numbers = readNumbers(text);

        validateNumbers(numbers);

        return calculateSum(numbers);

    }

    private List<Integer> readNumbers(String text) {
        final Parser parser = createParser(text);
        final String[] values = split(parser.getExpression(), parser.getSeparators());
        return Stream.of(values)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        final List<Integer> negatives = numbers.stream()
                .filter(i -> i < 0)
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }

    private int calculateSum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(value -> value)
                .filter(value -> value < 1000)
                .sum();
    }

    private Parser createParser(String text) {
        if (text.startsWith("//")) {
            return createParserWithCustomSeparators(text);
        } else {
            return createParserWithDefaultSeparators(text);
        }
    }

    private Parser createParserWithDefaultSeparators(String text) {
        final Parser parser = new Parser();
        parser.setSeparators(getDefaultSeparators());
        parser.setExpression(text);
        return parser;
    }

    private Parser createParserWithCustomSeparators(String text) {
        final String regex = "//(.)\n(.*\n?.*)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);
        matcher.matches();

        final Parser parser = new Parser();
        parser.setSeparators(getDefaultSeparators());
        parser.getSeparators().add(matcher.group(1));
        parser.setExpression(matcher.group(2));
        return parser;
    }

    private ArrayList<String> getDefaultSeparators() {
        return Lists.list(",", "\n");
    }

    private String[] split(String expression, List<String> separators) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        separators.forEach(sb::append);
        sb.append("]");

        return expression.split(sb.toString());
    }

    private int parseNumber(String text) {
        return Integer.parseInt(text);
    }
}
