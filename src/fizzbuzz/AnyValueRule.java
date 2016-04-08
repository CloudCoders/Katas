package fizzbuzz;

public class AnyValueRule implements Rule{

    @Override
    public String transform(int number, String response) {
        return response.isEmpty()? String.valueOf(number) : "";
    }


}
