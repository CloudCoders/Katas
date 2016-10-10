package romannumerals

import org.junit.Test
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

/**
 * I 1 to 3
 * IV 4
 * V 5
 * VI 6
 * VII 7
 * VIII 8
 * IX 9
 * X 10
 */
class RomanNumeralsParserShould {


  @Test fun `parse basic numerals`() {
    assertThat(parseToRoman(1), `is`("I"))
    assertThat(parseToRoman(5), `is`("V"))
    assertThat(parseToRoman(10), `is`("X"))
    assertThat(parseToRoman(50), `is`("L"))
    assertThat(parseToRoman(100), `is`("C"))
    assertThat(parseToRoman(500), `is`("D"))
    assertThat(parseToRoman(1000), `is`("M"))
  }

  @Test fun `parse one range numerals`() {
    assertThat(parseToRoman(2), `is`("II"))
    assertThat(parseToRoman(3), `is`("III"))
  }

  @Test fun `parse five range numerals`() {
    assertThat(parseToRoman(4), `is`("IV"))
    assertThat(parseToRoman(6), `is`("VI"))
    assertThat(parseToRoman(7), `is`("VII"))
    assertThat(parseToRoman(8), `is`("VIII"))
  }

  @Test fun `parse ten range numerals`() {
    assertThat(parseToRoman(9), `is`("IX"))
    assertThat(parseToRoman(11), `is`("XI"))
    assertThat(parseToRoman(12), `is`("XII"))
    assertThat(parseToRoman(14), `is`("XIV"))
    assertThat(parseToRoman(15), `is`("XV"))
    assertThat(parseToRoman(19), `is`("XIX"))
  }

  @Test fun `big range numerals`() {
    assertThat(parseToRoman(20), `is`("XX"))
    assertThat(parseToRoman(200), `is`("CC"))
    assertThat(parseToRoman(1993), `is`("MCMXCIII"))
  }

}