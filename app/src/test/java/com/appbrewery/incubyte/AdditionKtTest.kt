package com.appbrewery.incubyte

import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test

class AdditionKtTest {

    @Before
    fun setup() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun add_givenEmptyStr_returns0() {
        // Given
        val input = ""

        // when
        val result = add(input)

        // then
        Truth.assertThat(result).isEqualTo(0)
    }

    @Test
    fun add_givenSingleNumStr_returnsSumAsNum() {
        // Given
        val input = "5"

        // when
        val result = add(input)

        // then
        Truth.assertThat(result).isEqualTo(5)
    }

    @Test
    fun add_givenCommaSeparatedStr_returnsSum() {
        // given
        val input = "5,10,11,"

        // when
        val result = add(input)

        // then
        Truth.assertThat(result).isEqualTo(26)
    }

    @Test
    fun add_givenNewLineSeparatedStr_returnsSum() {
        // given
        val input = "5\n10\n11"

        // when
        val result = add(input)

        // then
        Truth.assertThat(result).isEqualTo(26)
    }

    @Test
    fun add_givenCommaOrNewLineSeparatedStr_returnsSum() {
        // given
        val input = "5,10\n11"

        // when
        val result = add(input)

        // then
        Truth.assertThat(result).isEqualTo(26)
    }

    @Test
    fun add_givenDelimiterStr_returnsSum() {
        // given
        val inputWithDelimiter = "//$\n1$2$3$4"

        // when
        val result = add(inputWithDelimiter)

        // then
        Truth.assertThat(result).isEqualTo(10)
    }

    @Test
    fun add_givenDoubleDollarDelimiterStr_returnsSum() {
        // given
        val inputWithDelimiter = "//$$\n1$$2$$3$$4"

        // when
        val result = add(inputWithDelimiter)

        // then
        Truth.assertThat(result).isEqualTo(10)
    }


    @Test
    fun isValidInput_containsNoConsecutiveDelimiter_returnsTrue() {
        // given
        val input = "1,2\n3"

        // when
        val result = isValidInput(input)

        // then
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun isValidInput_containsConsecutiveDelimiter_returnsFalse() {
        // given
        val input = "1\n\n2,\n"

        // when
        val result = isValidInput(input)

        // then
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun containsDelimiter_givenDollarAsDelimiter_returnsTrue() {
        // given
        val input = "//$\ndfjaljf"

        // when
        val result = containsDelimiter(input)

        // then
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun containsDelimiter_givenHashAsDelimeter_returnsTrue() {
        // given
        val input = "//#\ndfjaljf"

        // when
        val result = containsDelimiter(input)

        // then
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun containsDelimiter_givenNoDelimiter_returnsFalse() {
        // given
        val input = "//#dfjaljf"

        // when
        val result = containsDelimiter(input)

        // then
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun getDelimiter_givenDollarAsDelimiter_returnsDollar() {
        // given
        val input = "//$\ndfjaljf"

        // when
        val result = getDelimiter(input)

        // then
        Truth.assertThat(result).isEqualTo("$")
    }

    @Test
    fun getDelimiter_givenHashAsDelimiter_returnsDollar() {
        // given
        val input = "//#\ndfjaljf"

        // when
        val result = getDelimiter(input)

        // then
        Truth.assertThat(result).isEqualTo("#")
    }

    @Test
    fun getDelimiter_givenDoubleHashAsDelimiter_returnsDollar() {
        // given
        val input = "//##\ndfjaljf"

        // when
        val result = getDelimiter(input)

        // then
        Truth.assertThat(result).isEqualTo("##")
    }

    @Test
    fun getDelimiter_givenNoDelimiter_returnsEmptyStr() {
        // given
        val input = "//dfjaljf"

        // when
        val result = getDelimiter(input)

        // then
        Truth.assertThat(result).isEqualTo("")
    }

    @Test
    fun containsNegative_givenNoNegative_returnsFalse() {
        // given
        val inputList = listOf("1", "2", "3", "4")

        // when
        val result = containsNegative(inputList)

        // then
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun containsNegative_givenNegative_returnsTrue() {
        // given
        val inputList = listOf("1", "-2", "-3", "4")

        // when
        val result = containsNegative(inputList)

        // then
        Truth.assertThat(result).isTrue()
    }

}