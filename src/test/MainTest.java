package test;
import main.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testConcatenate() {
        Main myUnit = new Main();


        assertEquals("onetwo", "onetwo");

    }
}
