package csc223.ec;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FUberTest {
    
    @Test
    public void testEuclidean() {
       float expectedResult = 5;
       assertEquals(expectedResult, FUber.euclidean(3, 4, 0, 0));
    }

    @Test
    public void testManhattan() {
        float expectedResult = 7;
        assertEquals(expectedResult, FUber.manhattan(3,4,0,0));
    }
}
