import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

        matchingStrings has the following parameters:

        string strings[n] - an array of strings to search
        string queries[q] - an array of query strings*/
public class MatchingStrings {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");
        List<Integer> result = matchingStrings(strings, queries);
        System.out.println(result);
    }

    private static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            int count = 0;
            for (String string : strings) {
                if (query.equals(string)) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }


}
