package testing;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import src.PhoneNumber;



public class PhoneNumberTest {

    @Test
    public void testWithEmptyInput() {
        assertEquals(0, PhoneNumber.letterCombinations("").size());
    }

    @Test
    public void testSingleDigitInput() {
        assertEquals(Arrays.asList ("a","b","c"), PhoneNumber.letterCombinations("2"));
    }

    @Test
    public void testDoubleDigitInput() {
        assertEquals(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"), PhoneNumber.letterCombinations("23"));
    }

    @Test
    public void testTripleDigitInput() {
        assertEquals(Arrays.asList("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"), PhoneNumber.letterCombinations("234"));
    }
    @Test
    public void testOutputSorted() {
       // Test input "23"
        List<String> result = PhoneNumber.letterCombinations("23");
        PhoneNumber.insertionSort(result);
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected, result);
        // Test input "32"
        result = PhoneNumber.letterCombinations("32");
        Collections.sort(result);
        expected = Arrays.asList("da", "db", "dc", "ea", "eb", "ec", "fa", "fb", "fc");
        assertEquals(expected, result);
    }

}
