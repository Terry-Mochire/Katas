import java.util.Arrays;

public class Decode {
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] alphabetInverse = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

    public static void main(String[] args) {
        System.out.println(decode("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
        System.out.println(decode("wrw blf hvv ozhg mrtsg'h vkrhlwv?"));
    }

    private static String decode(String message) {
        String[] messageList = message.split(" ");
        String[] result = new String[messageList.length];

        for(int i = 0; i < messageList.length; i++){
            char[] chars = messageList[i].toCharArray();
            char[] resultChars = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {
                int value = chars[j];
                if (value < 97 && value > 32){
                    resultChars[j] = chars[j];
                } else {
                    int index = Arrays.binarySearch(alphabet, chars[j]);
                    resultChars[j] = alphabetInverse[index];
                }

            }
            result[i] = String.valueOf(resultChars);
        }
        return String.join(" ", result);
    }
}
