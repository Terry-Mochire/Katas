import java.util.HashSet;
import java.util.Set;

//Write a function that takes an array and returns true or false depending on whether the array contains duplicate integers
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] num1 = {1,7,3,4};
        int[] num2 = {1,1,3,4};
        System.out.println(containsDuplicate(num2));
        System.out.println(containsDuplicate(num1));
        System.out.println(betterSolution(num2));
        System.out.println(betterSolution(num1));
    }



    //    Brute Force Approach
    private static boolean containsDuplicate(int[] num1) {
        for (int k : num1) {
            for (int j = 1; j < num1.length; j++) {
                return k == num1[j];
            }
        }
        return false;
    }


//    Using a set
    private static boolean betterSolution(int[] num) {
        Set<Integer> store = new HashSet<>();
        boolean result = false;
        for (int j : num) {
            if (store.contains(j)) {
                result = true;
            }
            store.add(j);
        }
        return result;
    }

}
