package fizzbuzz;

public class BuzzRule implements Rule {

    @Override
    public String transform(int number, String response) {
        return isBuzz(number)? FizzBuzz.BUZZ : "";
    }

    private boolean isBuzz(int i) {
        return i % FizzBuzz.BUZZ_VALUE == 0;
    }
}
