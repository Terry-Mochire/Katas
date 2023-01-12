/*
 * In a text file, there is a single character H. Your text editor can execute only two operations in this file: Copy All and Paste.
 * Given a number n, write a method that calculates the fewest number of operations needed to result in exactly n H characters in the file.
 *
 * Example:
 * Input: 9
 * H => Copy All => Paste => HH => Paste =>HHH => Copy All => Paste => HHHHHH => Paste => HHHHHHHHH
 * Output: 6
 * */


public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(addCount(9));
        System.out.println(addCount(4));
        System.out.println(addCount(12));
    }


    public static int addCount(int n) {
        int countOfH = 1;
        int otherCountOfH = 1;
        int numberOfOperations = 0;


        while (countOfH != n) {
                if (countOfH % 2 == 1 || countOfH == n / 2) {
                    numberOfOperations = numberOfOperations + 2;
                    countOfH = countOfH + countOfH;
                } else {
                    numberOfOperations = numberOfOperations + 1;
                    countOfH = countOfH + otherCountOfH;
                    otherCountOfH = countOfH;
                }
        }

        return numberOfOperations;
    }
}
