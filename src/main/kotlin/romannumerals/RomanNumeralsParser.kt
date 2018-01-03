package romannumerals

fun parseToRoman(number: Int): String {
  val parser: RomanNumeralsParser = RomanNumeralsParser()

  return parser.parse(number)
}

class RomanNumeralsParser {

  val romanBasics = mapOf<Int, String>(Pair(1000, "M"),
                               Pair(900, "CM"),
                               Pair(500, "D"),
                               Pair(400, "CD"),
                               Pair(100, "C"),
                               Pair(90, "XC"),
                               Pair(50, "L"),
                               Pair(40, "XL"),
                               Pair(10, "X"),
                               Pair(9, "IX"),
                               Pair(5, "V"),
                               Pair(4, "IV"),
                               Pair(1, "I")
      )

  fun parse(number: Int): String {

    var result = ""
    var num = number

    romanBasics
        .filterKeys { num >= it }
        .forEach {
          while(num >= it.key) {
            result += it.value
            num -= it.key
          }
        }

    return result
  }

}