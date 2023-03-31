//Write a function:
//
//  class Solution { public int solution(int[] A); }
//
//  that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class SmallestInteger {

    public int solution(int[] A) {
        int smallest = 1;

        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        sort(list);

        for (Integer integer : list) {
            if (integer > 0) {
                if (integer == smallest) {
                    smallest++;
                } else if (integer > smallest) {
                    return smallest;
                }
            }
        }
        return smallest;
    }


}
