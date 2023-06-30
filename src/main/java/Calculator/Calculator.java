package Calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {
    public static int sum(String input) {
        if (!input.isEmpty()){
            if (input.endsWith(",")){
                throw new IllegalArgumentException("Input cannot end with a delimiter");
            }
            String delimiter = ",|\n";
            if (input.startsWith("//")){
                String[] parts = input.split("\n", 2);
                input = parts[1];
                delimiter = parts[0].substring(2);
            }
            Stream<String> numbers = Arrays.stream(input.split(delimiter));
            if (numbers.anyMatch(number -> Integer.parseInt(number) < 0)){
                throw new IllegalArgumentException("Input cannot contain negative numbers");
            }
            numbers = Arrays.stream(input.split(delimiter));
            return numbers.mapToInt(Integer::parseInt).sum();
        }
        return 0;
    }
}
