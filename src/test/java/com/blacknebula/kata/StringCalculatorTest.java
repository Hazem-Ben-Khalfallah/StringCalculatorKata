package com.blacknebula.kata;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    /**
     * @verifies return zero if input is an empty string
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnZeroIfInputIsAnEmptyString() {
        checkInput("", 0);
    }

    /**
     * @verifies return same value if one number is passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSameValueIfOneNumberIsPassed() {
        checkInput("4", 4);
    }

    /**
     * @verifies return sum if two numbers are passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSumIfTwoNumbersArePassed() throws Exception {
        checkInput("1,3", 4);
    }

    /**
     * @verifies return sum if any amount of numbers
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSumIfAnyAmountOfNumbers() throws Exception {
        checkInput("1,2,3,4", 10);

    }

    private void checkInput(String input, int expectedResult) {
        // when
        final int result = stringCalculator.add(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}