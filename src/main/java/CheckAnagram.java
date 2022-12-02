import java.util.ArrayList;
import java.util.Arrays;

public class CheckAnagram {
    public static void main(String[] args) {
        System.out.println(checkAnagram("anagram", "nagaram"));
        System.out.println(checkAnagram("rat", "car"));
    }

    private static boolean checkAnagram(String anagram, String nagaram) {
        if (anagram.length() != nagaram.length()){
            return false;
        }
        char[] anagramList = anagram.toCharArray();
        char[] nagaramList = nagaram.toCharArray();

        Arrays.sort(anagramList);
        Arrays.sort(nagaramList);

        return Arrays.equals(anagramList, nagaramList);
    }
}
