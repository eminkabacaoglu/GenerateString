import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class GenerateTest extends TestCase {
    public char[] chrs={'a','b','c'};
    Generate g = new Generate(3,2,10,chrs,"test");
    @Test
    public void testCheckCombination() throws Exception {

        boolean res = g.checkCombination(3,2,10,chrs);
        assertEquals(true,res);
    }

    
}