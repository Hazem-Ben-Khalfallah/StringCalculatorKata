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
        // given
        final String input = "";

        // when
        final int result = stringCalculator.add(input);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    /**
     * @verifies return same value if one number is passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSameValueIfOneNumberIsPassed() {
        // given
        final String input = "4";

        // when
        final int result = stringCalculator.add(input);

        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    /**
     * @verifies return sum if two numbers are passed
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnSumIfTwoNumbersArePassed() throws Exception {
        // given
        final String input = "1,3";

        // when
        final int result = stringCalculator.add(input);

        // then
        Assertions.assertThat(result).isEqualTo(4);
    }
}