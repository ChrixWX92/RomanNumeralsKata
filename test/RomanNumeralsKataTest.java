import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsKataTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Roman Numerals to 3999.csv")
    public void checkRomanNumeralsTo3999 (int number, String numeral) {
        assertEquals(RomanNumeralsKata.arabicToRoman(number), numeral);
    }

    @RepeatedTest(5)
    public void checkRomanNumeralsOver3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralsKata.arabicToRoman(ThreadLocalRandom.current().nextInt(4000, Integer.MAX_VALUE)));
    }

    @Test
    public void checkRomanNumeralsWith0() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralsKata.arabicToRoman(0));
    }

    @RepeatedTest(5)
    public void checkRomanNumeralsWithNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralsKata.arabicToRoman(ThreadLocalRandom.current().nextInt(-1, Integer.MIN_VALUE)));
    }


}