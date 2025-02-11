package csc223.ec;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DNATest {
    
    @Test
    public void testCountNucleotides() {
        String testNucleo = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        String testString = "20 12 17 21";
        String resultNucleo = DNA.countNucleotides(testNucleo);
        assertEquals(testString, resultNucleo);
    }

    @Test
    public void testTranscribe() {
        String testData = "GATGGAACTTGACTACGTAAATT";
        String expectedResult = "GAUGGAACUUGACUACGUAAAUU";
        assertEquals(expectedResult, DNA.transcribe(testData));
    }

    @Test
    public void testReverseComplement() {
        String testData = "AAAACCCGGT";
        String expectedResult = "ACCGGGTTTT";
        assertEquals(expectedResult, DNA.reverseComplement(testData));
    }

}
