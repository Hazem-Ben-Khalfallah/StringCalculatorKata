package com.blacknebula.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StringCalculatorTest {


    /**
     * @verifies return zero if input is an empty string
     * @see StringCalculator#add(String)
     */
    @Test
    public void add_shouldReturnZeroIfInputIsAnEmptyString() {
        // given
        final String input = "";
        final StringCalculator stringCalculator = new StringCalculator();

        // when
        final int result = stringCalculator.add(input);

        // then
        Assertions.assertThat(result).isEqualTo(0);
    }
}