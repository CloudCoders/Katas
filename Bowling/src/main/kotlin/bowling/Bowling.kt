package bowling

class Bowling {

  private val SPARE = '/'
  private val STRIKE = 'X'
  private val NORMAL_FRAMES = 18

  fun score(frames: String): Int {
    return frames.foldIndexed(0) { idx, score, roll ->
      score + score(roll, score(frames.previous(idx))) + bonus(frames, roll, idx)
    }
  }

  private fun bonus(frames: String, roll: Char, idx: Int): Int {
    val nextButOne = frames.next(idx)
    return when {
      roll == SPARE && !isLastFrame(frames, idx) -> score(nextButOne)
      roll == STRIKE && ! isLastFrame(frames, idx) ->
        score(nextButOne) + score(frames.next(idx + 1), score(nextButOne))
      else -> 0
    }
  }

  private fun isLastFrame(frames: String, idx: Int): Boolean {
    return NORMAL_FRAMES <= frames.substring(0, idx)
            .sumBy { roll -> if(roll == STRIKE) 2 else 1 }
  }

  private fun score(roll: Char, spareDiff: Int = 0): Int {
    return when (roll) {
      in '1' .. '9' -> roll.toString().toInt()
      SPARE -> 10 - spareDiff
      STRIKE -> 10
      else -> 0
    }
  }

}

private fun String.next(idx: Int): Char = if(idx < length - 1) this[idx + 1] else '-'

private fun String.previous(idx: Int): Char = if (idx > 0) this[idx - 1] else '-'
