import java.util.Arrays;
import java.util.List;

public class RomanNumeralsKata {

    static List<String[]> numerals = Arrays.asList(
        new String[]{"I", "V"},
        new String[]{"X", "L"},
        new String[]{"C", "D"},
        new String[]{"M", "V̅"},
        new String[]{"X̅", ""}
    );

    public static String arabicToRoman(int arabicNumber){

        if (arabicNumber > 3999) {
            throw new IllegalArgumentException("Value too large to convert to Roman Numeral without additional character support.");
        }
        if (arabicNumber < 1) {
            throw new IllegalArgumentException("No Roman Numeral equivalent for value " + arabicNumber + ".");
        }

        String arabicString =  new StringBuilder(Integer.toString(arabicNumber)).reverse().toString();
        int[] digits = new int[arabicString.length()];
        for (int i = 0; i < arabicString.length(); i++) digits[i] = arabicString.charAt(i) - '0';
        StringBuilder romanNumeral = new StringBuilder();

        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            int digit = digits[i];
            if (digit == 0) continue;
            if (digit == 4) {romanNumeral.append(numerals.get(i)[0]).append(numerals.get(i)[1]); continue;}
            if (digit == 9) {romanNumeral.append(numerals.get(i)[0]).append(numerals.get(i + 1)[0]); continue;}
            if (digit >= 5) {romanNumeral.append(numerals.get(i)[1]); digit -= 5;}
            while (digit > 0) {romanNumeral.append(numerals.get(i)[0]);--digit;}
        }

        return romanNumeral.toString();

    }

}
