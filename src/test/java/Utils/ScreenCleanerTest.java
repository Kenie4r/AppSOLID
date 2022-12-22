package Utils;

import org.junit.jupiter.api.Test;
import org.kodigo.Utils.ScreenCleaner;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ScreenCleanerTest {

    @Test
    void testCleanScreen(){
        assertAll(ScreenCleaner::cleanScreen);
    }

}
