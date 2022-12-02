// A string str contains a list of color names that are separated by a single space
// Colors in str are mixed up but each color has its original position at the end of the color name, positions are 1-indexed
// Write a function that returns a string with the colors sorted by their original position
// Example:
// str = "red4 green3 blue1 yellow2"
// output = "blue yellow green red"

public class OrderColors {
    public static void main(String[] args) {
        System.out.println(orderColors("red4 green3 blue1 yellow2"));
    }

    private static String orderColors(String str) {
        String[] colors = str.split(" ");
        String[] sortedColors = new String[colors.length];
        for (String color : colors) {
            int index = Integer.parseInt(color.substring(color.length() - 1));
            sortedColors[index - 1] = color.substring(0, color.length() - 1);
        }
        return String.join(" ", sortedColors);
    }
}
