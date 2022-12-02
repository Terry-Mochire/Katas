// Convert a non-negative integer num to its English words representation.

/*
123 - One hundred Twenty Three
12345 - Twelve Thousand Three Hundred Forty Five
1234567 - One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
* */


public class IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));

    }

    private static String numberToWords(int i) {
        if (i == 0) return "Zero";
        int billion = i / 1000000000;
        int million = (i - billion * 1000000000) / 1000000;
        int thousand = (i - billion * 1000000000 - million * 1000000) / 1000;
        int rest = i - billion * 1000000000 - million * 1000000 - thousand * 1000;
        String result = "";
        if (billion != 0) result += helper(billion) + " Billion" + " ";
        if (million != 0) result += helper(million) + " Million" + " ";
        if (thousand != 0) result += helper(thousand) + " Thousand" + " ";
        if (rest != 0) result += helper(rest);
        return result.trim();
    }

    private static String helper(int billion) {
        String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int hundred = billion / 100;
        int ten = (billion - hundred * 100) / 10;
        int one = billion - hundred * 100 - ten * 10;
        String result = "";
        if (hundred != 0) result += belowTen[hundred] + " Hundred";
        if (ten == 1) result += " " + belowTwenty[one];
        else {
            if (ten != 0) result += " " + belowHundred[ten];
            if (one != 0) result += " " + belowTen[one];
        }
        return result;
    }


}