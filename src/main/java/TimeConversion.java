import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);

        System.out.println(result);

        bufferedReader.close();

    }

    private static String timeConversion(String s) {
        String[] time = s.split(":");
        String hour = time[0];
        String minute = time[1];
        String second = time[2].substring(0, 2);
        String amPm = time[2].substring(2, 4);
        String militaryTime;
        if (amPm.equals("AM")) {
            if (hour.equals("12")) {
                militaryTime = "00" + ":" + minute + ":" + second;
            } else {
                militaryTime = hour + ":" + minute + ":" + second;
            }
        } else {
            if (hour.equals("12")) {
                militaryTime = hour + ":" + minute + ":" + second;
            } else {
                militaryTime = (Integer.parseInt(hour) + 12) + ":" + minute + ":" + second;
            }
        }
        return militaryTime;

    }
}
