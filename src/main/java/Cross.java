import java.util.Arrays;

//  Your task is to implement a simplified version of an in-memory database. Plan your design according to the level specifications below
// Level 1: In-memory database should support basic operations to manipulate records, fields, and values within fields.
// The basic level of the in-memory database contains records. Each record can be accessed with a unique identifier <key> of string type. A record may contain several"<field>"-"<value>" pairs (i.e. <value> mapped to <field>), both of which are of string type.
//
//  SET <key> <field> <value> - should insert a field-value pair to the record associated with key. If the field in the record already exists, then replace the existing value by the specified value. If the record does not exist, a new one is created. This operation should return an empty string.
//
//  GET <key> <field> - should return the value contained within field of the record associated with key. If the record or the field doesn't exist, returns an empty string.
//
//  DELETE <key> <field> - should remove the field from the record associated with key. Returns "true" if the field was successfully deleted, and "false" if the key or the field do not exist in the database.
// SCAN <key> <prefix> - should return a string representing some fields of a record associated with key.
// Specifically, only fields which start with prefix should be included (if prefix is an empty string, all fields are included).
// The returned string should be in the following format "field1(value1), field2(value2), ...", where fields are sorted lexicographically. If the specified record does not exist, returns "".
public class Cross {

    public static void main(String[] args) {

        String[][] queries = {{"SET","employee1","city","Annapolis"}, {"SET","employee2","id","0123"}, {"GET","employee1","city"}};
        String[][] queries2 = {{"GET","dept4","name"}, {"GET","dept4","name"}, {"SET","dept4","name","Main"}, {"SET","dept4","name","Main"}, {"GET","dept4","name"}};
        String[][] queries3 = {{"SET","book1","title","Island"}, {"GET","book1","title"}, {"DELETE","book1","title"}, {"GET","book1","title"}};
        String[][] queries4 = {{"SET","A","BC","D"}, {"SET","AB","C","E"},
                {"DELETE","BC","A"},
                {"GET","BC","A"},
                {"GET","A","BC"},
                {"DELETE","A","BC"},
                {"DELETE","A","BC"},
                {"DELETE","B","AC"},
                {"DELETE","A","BC"},
                {"GET","A","BC"},
                {"GET","AB","C"}};
        String[][] queries5 = {{"SET","dept4","first","1"},
                {"SET","dept4","second","2"},
                {"SET","dept4","fifth","5"},
                {"SCAN","dept4","fi"},
                {"GET","dept4","first"},
                {"SCAN","dept4","sec"}};


        String[][] queries6 = {{"SET","a","a","b"},
                {"SET","a","A","c"},
                {"SCAN","a","a"},
                {"DELETE","a","a"},
                {"DELETE","a","A"},
                {"SET","a","A","b"},
                {"SET","a","A","c"},
                {"SCAN","a",""},
                {"SCAN","a","A"},
                {"GET","a","A"},
                {"SET","A","A","B"},
                {"SCAN","A",""}};

        System.out.println(Arrays.toString(solution(queries)));
        System.out.println(Arrays.toString(solution(queries2)));
        System.out.println(Arrays.toString(solution(queries3)));
        System.out.println(Arrays.toString(solution(queries4)));
        System.out.println(Arrays.toString(solution(queries5)));
        System.out.println(Arrays.toString(solution(queries6)));

    }

    static String[] solution(String[][] queries) {
        String[] result = new String[queries.length];
        String[][] container = new String[queries.length][3];
        int count = 0;

        for (String[] query : queries) {
            String operation = query[0];
            String key = query[1];
            String field = query[2];


            switch (operation) {
                case "SET" -> {
                    String value = query[3];
                    container[count][0] = key;
                    container[count][1] = field;
                    container[count][2] = value;
                    result[count] = "";
                    count++;
                }
                case "GET" -> {
                    String value = "";
                    for (int j = 0; j < container.length; j++) {
                        if (container[j][0] != null && container[j][0].equals(key) && container[j][1].equals(field)) {
                            value = container[j][2];
                        }
                    }
                    result[count] = value;
                    count++;
                }
                case "DELETE" -> {
                    boolean deleted = false;
                    for (int j = 0; j < container.length; j++) {
                        if (container[j][0] != null && container[j][0].equals(key) && container[j][1].equals(field)) {
                            container[j][0] = null;
                            container[j][1] = null;
                            container[j][2] = null;
                            deleted = true;
                        }
                    }
                    result[count] = String.valueOf(deleted);
                    count++;
                }
                case "SCAN" -> {
                    String prefix = query[2];
                    String value = "";
                    for (String[] strings : container) {
                        if (strings[0] != null && strings[0].equals(key) && (strings[1].startsWith(prefix) || prefix.equals(""))) {
                            value += strings[1] + "(" + strings[2] + "), ";
                        }
                    }
                    String[] values = value.split(", ");
                    Arrays.sort(values);
                    value = "";
                    for (String s : values) {
                        value += s + ", ";
                    }
                    value = value.substring(0, value.length() - 2);
                    result[count] = value;
                    count++;


                }
            }

        }
        return result;

    }
}
