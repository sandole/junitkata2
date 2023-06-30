package Calculator;

import java.util.Arrays;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers){
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    private int sum(){
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt)
                .map(n -> {
                    if (n < 0)
                        throw new IllegalArgumentException("Negatives not allowed: " + n);
                    return n;
                })
                .filter(n -> n <= 1000)
                .sum();
    }

    public static int sum(String input) {
        if (input.isEmpty())
            return 0;
        return parseInput(input).sum();
    }

    private static StringCalculator parseInput(String input){
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            return new StringCalculator(parts[0].substring(2), parts[1]);
        } else if (input.endsWith(",")){
            throw new IllegalArgumentException("Input cannot end with comma");
        } else {
            return new StringCalculator(",|\n", input);
        }
    }
}
