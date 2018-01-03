package fizzbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final int BUZZ_VALUE = 5;
    public static final int FIZZ_VALUE = 3;

    List<Rule> rules = new ArrayList();

    public FizzBuzz() {
        List<Rule> ruleList = Arrays.asList(new FizzRule(), new BuzzRule(), new AnyValueRule());
        rules.addAll(ruleList);
    }

    public static void main(String... args){

        FizzBuzz fizzBuzz = new FizzBuzz();

        for (int i = 0; i < 100; i++){
            System.out.println(fizzBuzz.fizzBuzzValue(i));
        }

    }

    public String fizzBuzzValue(int number) {
        String result = "";

        for (Rule rule : rules) {
            result += rule.transform(number, result);
        }

        return result;
    }
}