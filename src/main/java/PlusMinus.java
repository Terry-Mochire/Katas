/*Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
        Print the decimal value of each fraction on a new line with 6 places after the decimal.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();

    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (Integer integer : arr) {
            if (integer > 0) {
                positive++;
            } else if (integer < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println(df.format((double) positive / arr.size()));
        System.out.println((df.format((double) negative / arr.size())));
        System.out.println((df.format((double) zero / arr.size())));

    }
}
