public class CountSalutes {
    public static void main(String[] args) {
        System.out.println(countSalutes("<<>><"));
        System.out.println(countSalutes(">----<"));
        System.out.println(countSalutes("--->-><-><-->-"));
    }


    private static int countSalutes(String s) {
        int count = 0;
        int salutes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                count++;
            } else if (s.charAt(i) == '<'){
                salutes += count * 2;
            }
        }
        return salutes;

    }
}
