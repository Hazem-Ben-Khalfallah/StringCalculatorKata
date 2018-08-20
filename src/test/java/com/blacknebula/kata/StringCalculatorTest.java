package com.blacknebula.kata;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hazem
 */
public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    /**
     * @verifies return zero if an empty String is passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnZeroIfAnEmptyStringIsPassed() throws Exception {
        // given
        final String input = "";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    /**
     * @verifies return same number if a unique number is passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSameNumberIfAUniqueNumberIsPassed() throws Exception {
        // given
        final String input = "3";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(3);
    }

    /**
     * @verifies return the sum of two numbers
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnTheSumOfTwoNumbers() throws Exception {
        // given
        final String input = "2,3";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(5);
    }

    /**
     * @verifies return the sum of any amount of numbers
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnTheSumOfAnyAmountOfNumbers() throws Exception {
        // given
        final String input = "1,2,3,4";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(10);
    }

    /**
     * @verifies handle new lines between numbers
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldHandleNewLinesBetweenNumbers() throws Exception {
        // given
        final String input = "1\n2,3";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(6);
    }

    /**
     * @verifies support a different delimiter
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldSupportADifferentDelimiter() throws Exception {
        // given
        final String input = "//;\n1;2,3\n4;5";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(15);
    }

    /**
     * @verifies throw an exception if a negative has been added using default separators
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldThrowAnExceptionIfANegativeHasBeenAddedUsingDefaultSeparators() throws Exception {
        // given
        final String input = "-2\n1,-3";
        try {
            // when
            stringCalculator.add(input);
            Assert.fail("should fail");
        } catch (IllegalArgumentException e){
            // then
            Assertions.assertThat(e.getMessage()).isEqualTo("negatives not allowed: [-2, -3]");
        }
    }

    /**
     * @verifies throw an exception if a negative has been added using a custom separator
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldThrowAnExceptionIfANegativeHasBeenAddedUsingACustomSeparator() throws Exception {
        // given
        final String input = "//;\n1;2,-3;-4";
        try {
            // when
            stringCalculator.add(input);
            Assert.fail("should fail");
        } catch (IllegalArgumentException e){
            // then
            Assertions.assertThat(e.getMessage()).isEqualTo("negatives not allowed: [-3, -4]");
        }
    }

    /**
     * @verifies ignore numbers greater than 1000
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldIgnoreNumbersGreaterThan1000() throws Exception {
        // given
        final String input = "1,999,1000";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(1000);
    }

    /**
     * @verifies return 0 if all numbers are greater than 1000
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturn0IfAllNumbersAreGreaterThan1000() throws Exception {
        // given
        final String input = "2000,1000";
        // when
        final int result = stringCalculator.add(input);
        // then
        Assertions.assertThat(result).isEqualTo(0);
    }
}