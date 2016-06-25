package fizzbuzz;

public class FizzRule implements Rule{

    @Override
    public String transform(int number, String response) {
        return isFizz(number) ? FizzBuzz.FIZZ : response;
    }

    private boolean isFizz(int i) {
        return i % FizzBuzz.FIZZ_VALUE == 0;
    }
}
