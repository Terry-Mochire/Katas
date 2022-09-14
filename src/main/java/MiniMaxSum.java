/*      Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
        Then print the respective minimum and maximum values as a single line of two space-separated long integers.*/

/*      Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers.
        (The output can be greater than a 32-bit integer.)*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    private static void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);

        long minimumTotal = 0;
        long maximumTotal = 0;

        for(int i = 0; i < arr.size() - 1; i++){
            minimumTotal += arr.get(i);
        }

        for (int i = 1; i < arr.size(); i++){
            maximumTotal += arr.get(i);
        }

        System.out.println(minimumTotal + " " + maximumTotal);
    }
}
