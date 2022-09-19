/*Function Description

        Complete the lonely-integer function in the editor below.

        lonely-integer has the following parameter(s):

        int a[n]: an array of integers
        Returns

        int: the element that occurs only once*/

import java.util.List;
import java.util.ListResourceBundle;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> a = List.of(2, 1, 2);
        System.out.println(lonelyinteger(a));
    }

    private static int lonelyinteger(List<Integer> a) {
        int result = 0;
        for (Integer integer : a) {
            result ^= integer;
        }
        return result;


    }
}
