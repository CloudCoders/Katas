package bowling

private const val SPARE = '/'
private const val MISS = '-'
private const val STRIKE = 'X'
private const val NORMAL_FRAMES: Int = 18

class Bowling {
  val bowlingRules = listOf<BowlingRule>(LastFrameRule(), NormalRule(), SpareRule(), StrikeRule())

  fun score(frames: String): Int =
      frames.foldIndexed(0) { idx, score, roll ->
        score + bowlingRules
            .filter {
              !isLastFrame(frames, idx).xor(it is LastFrameRule)
            }
            .sumBy { it.scoreRule(frames, idx, roll) }
      }
}

private fun isLastFrame(frames: String, idx: Int) =
    NORMAL_FRAMES <= frames.substring(0, idx)
        .sumBy { roll -> if (roll == STRIKE) 2 else 1 }

private fun String.next(idx: Int) =
    if (idx < length - 1) this[idx + 1] else MISS

private fun String.previous(idx: Int) =
    if (idx > 0) this[idx - 1] else MISS

private fun score(roll: Char, spareDiff: Int = 0) =
    when (roll) {
      in '1'..'9' -> roll.toString().toInt()
      SPARE -> 10 - spareDiff
      STRIKE -> 10
      else -> 0
    }

interface BowlingRule {
  fun scoreRule(frames: String, idx: Int, roll: Char): Int
}

class NormalRule : BowlingRule {
  override fun scoreRule(frames: String, idx: Int, roll: Char): Int {
    return if (roll in '1' .. '9') roll.toString().toInt() else 0
  }
}

class SpareRule() : BowlingRule {
  override fun scoreRule(frames: String, idx: Int, roll: Char): Int {
    return if (roll == SPARE) {
      (10 - score(frames.previous(idx))) + score(frames.next(idx))
    } else 0
  }
}

class StrikeRule(): BowlingRule {
  override fun scoreRule(frames: String, idx: Int, roll: Char): Int {
    return if (roll == STRIKE) {
      val next = frames.next(idx)
      10 + score(next) + score(frames.next(idx + 1), score(next))
    } else 0
  }
}

class LastFrameRule(): BowlingRule {
  override fun scoreRule(frames: String, idx: Int, roll: Char): Int {
    return score(frames[idx], score(frames.previous(idx)))
  }
}