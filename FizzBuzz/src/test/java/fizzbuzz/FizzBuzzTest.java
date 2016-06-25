package fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    private static final String FIZZ_VALUE = "Fizz";
    private static final String BUZZ_VALUE = "Buzz";
    private static final String ANY_VALUE = "1";
    private static final String FIZZBUZZ_VALUE = "FizzBuzz";
    public static final int THREE = 3;
    public static final int DIVISIBLE_BY_THREE = 6;
    public static final int FIVE = 5;
    public static final int DIVISIBLE_BY_FIVE = 10;
    public static final int DIVISIBLE_BY_THREE_AND_FIVE = 30;
    public static final int ANY_NUMBER = 1;
    private FizzBuzz fizzbuzz;

    @Before
    public void setUp(){
        fizzbuzz = new FizzBuzz();
    }

    @Test public void
    should_return_fizz_when_the_number_is_three(){
        String fizz = fizzbuzz.fizzBuzzValue(THREE);

        assertEquals(FIZZ_VALUE, fizz);
    }

    @Test public void
    should_return_fizz_when_the_number_is_divisible_by_three(){
        String fizz = fizzbuzz.fizzBuzzValue(DIVISIBLE_BY_THREE);

        assertEquals(FIZZ_VALUE, fizz);
    }

    @Test public void
    should_return_buzz_when_the_number_is_five(){
        String buzz = fizzbuzz.fizzBuzzValue(FIVE);

        assertEquals(BUZZ_VALUE, buzz);
    }

    @Test public void
    should_return_buzz_when_the_number_is_divisible_by_five(){
        String buzz = fizzbuzz.fizzBuzzValue(DIVISIBLE_BY_FIVE);

        assertEquals(BUZZ_VALUE, buzz);
    }

    @Test public void
    should_return_same_number_in_string(){
        String one = fizzbuzz.fizzBuzzValue(ANY_NUMBER);

        assertEquals(ANY_VALUE, one);
    }

    @Test public void
    should_return_fizzbuzz_when_the_number_is_divisible_by_three_and_five(){
        String fizzbuzz = this.fizzbuzz.fizzBuzzValue(DIVISIBLE_BY_THREE_AND_FIVE);

        assertEquals(FIZZBUZZ_VALUE, fizzbuzz);
    }
}