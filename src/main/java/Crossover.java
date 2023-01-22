// Your task is to implement a simple container of integer numbers.
// As a first step, consider implementing the following two operations:
//  ADD <value> should add the specified integer value to the container. Returns an empty string.
//  EXISTS <value> should check whether the specific integer value exists in the container. Returns "true" if the value exists, "false" otherwise.
// REMOVE <value> should remove a single occurrence of the specified value from the container. If the value has multiple occurrences, only one of them should be removed.
// GET_NEXT <value> should return the minimal integer in the container that is strictly greater than the provided value. In case there is no such integer in the container, return empty string.
// The container is supposed to be empty at the beginning of execution.
//
//Given a list of queries, return the list of answers for these queries.
// To pass to the next level you have to pass all tests at this level.


import java.util.Arrays;

public class Crossover {

    public static void main(String[] args) {
       // Initialize a variable called queries that is an array of arrays of strings
        String[][] queries = {{"ADD", "1"}, {"ADD", "2"}, {"ADD", "3"}, {"EXISTS", "1"}, {"EXISTS", "2"}, {"EXISTS", "3"}, {"EXISTS", "4"}};
        String[][] queries2 = {{"EXISTS", "0"}, {"EXISTS", "10"}, {"ADD", "2"}, {"ADD", "3"}, {"ADD", "9"}, {"EXISTS", "3"}, {"EXISTS", "4"}, {"EXISTS", "9"},
                {"EXISTS", "10"},
                {"ADD", "10"},
                {"ADD", "0"},
                {"EXISTS", "0"},
                {"EXISTS", "1"},
                {"EXISTS", "2"},
                {"EXISTS", "3"},
                {"EXISTS", "4"},
                {"EXISTS", "9"},
                {"EXISTS", "10"},
                {"EXISTS","11"}};
        String[][] queries3 = {{"ADD", "1"}, {"ADD", "2"}, {"ADD", "2"} ,{"ADD", "3"}, {"EXISTS", "1"}, {"EXISTS", "2"}, {"EXISTS", "3"}, {"REMOVE", "2"},{"REMOVE", "1"} , {"EXISTS", "2"}, {"EXISTS", "1" }};
         System.out.println(Arrays.toString(solution(queries)));
         System.out.println(Arrays.toString(solution(queries2)));
        System.out.println(Arrays.toString(solution(queries3)));

    }

    static String[] solution(String[][] queries) {
        // Initialize a variable called result that is an array of strings
        String[] result = new String[queries.length];
        // Initialize a variable called container that is an array of integers
        String[] container = new String[queries.length];
        // Initialize a variable called count that is an integer
        int count = 0;
        // Iterate through the queries array

        for (int i = 0; i < queries.length; i++) {
            // Initialize a variable called query that is an array of strings
            String[] query = queries[i];
            // Initialize a variable called operation that is a string
            String operation = query[0];
            // Initialize an " " string called value
            String value = query[1];
            // If the operation is ADD
            switch (operation) {
                case "ADD" -> {
                    // Add the value to the container
                    container[count] = query[1];
                    result[count] = " ";

                    // Increment the count
                    count++;
                }
                case "EXISTS" -> {
                    // Initialize a variable called exists that is a boolean
                    boolean exists = false;
                    // Iterate through the container
                    for (String s : container) {
                        // If the value is equal to the container value
                        if (value.equals(s)) {
                            // Set exists to true
                            exists = true;
                            break;
                        }
                    }
                    // If exists is true
                    if (exists) {
                        // Add "true" to the result
                        result[i] = "true";
                    } else {
                        // Add "false" to the result
                        result[i] = "false";
                    }
                    count++;
                }
                case "REMOVE" -> {
                    // Initialize a variable called exists that is a boolean
                    boolean exists = false;
                    // Iterate through the container
                    for (int j = 0; j < container.length; j++) {
                        // If the value is equal to the container value remove the first occurrence of the value
                        if (value.equals(container[j])) {
                            container[j] = " ";
                            exists = true;
                            break;
                        }
                    }
                    // If exists is true
                    if (exists) {
                        // Add "true" to the result
                        result[i] = "true";
                    } else {
                        // Add "false" to the result
                        result[i] = "false";
                    }
                    count++;
                }
                case "GET_NEXT" -> {
                    // Initialize a variable called exists that is a boolean
                    boolean exists = false;
                    // Initialize a variable called next that is an integer
                    int next = 0;

                    // Iterate through the container
                    for (String s : container) {
                        // If the value is equal to the container value
                        if (value.equals(s)) {
                            // Set exists to true
                            exists = true;
                            break;
                        }
                    }

                    // If exists is true
                    if (exists) {
                        // Iterate through the container
                        for (String s : container) {
                            // If the value is equal to the container value
                            if (value.equals(s)) {
                                // Set exists to true
                                exists = true;
                                break;
                            }
                        }
                        // Add "true" to the result
                        result[i] = "true";
                    } else {
                        // Add "false" to the result
                        result[i] = "false";
                    }
                }
            }

}

        // Return the result
        return result;
    }
}
