package bowling

import org.junit.Test
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

class BowlingShould {

  @Test fun `minimum bowling score`() {
    val score: Int = Bowling().score("--------------------")
    assertThat(score, `is`(0))
  }

  @Test fun `there is always one foot`() {
    val score: Int = Bowling().score("9-9-9-9-9-9-9-9-9-9-")
    assertThat(score, `is`(9*10))
  }

  @Test fun `calculate when never do strike or spare`() {
    val score: Int = Bowling().score("54545454545454545454")
    assertThat(score, `is`(5*10+4*10))
  }

  @Test fun `calculate spare`() {
    var score = Bowling().score("5/5/-")
    assertThat(score, `is`(25))

    score = Bowling().score("5/5/5/5/5/5/5/5/5/5/5")
    assertThat(score, `is`(150))

    score = Bowling().score("2/2/2/2/2/2/2/2/2/2/1")
    assertThat(score, `is`(12 * 9 + 11))
  }

  @Test fun `calculate strike`() {
    var score: Int = Bowling().score("X")
    assertThat(score, `is`(10))
    score = Bowling().score("XXXXXXXXXXXX")
    assertThat(score, `is`(10*10*3))

    score = Bowling().score("X52")
    assertThat(score, `is`(24))
  }
  
  @Test fun `calculate strikes and spares`() {
    assertThat(Bowling().score("1/X1/2"), `is`(54))

    assertThat(Bowling().score("1/35XXX458/X3/XX6"), `is`(189))
  }
}