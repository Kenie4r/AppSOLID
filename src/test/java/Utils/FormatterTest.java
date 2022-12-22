package Utils;

import org.junit.jupiter.api.Test;
import org.kodigo.Utils.Formatter;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FormatterTest {

    @Test
    public  void testMail(){
        boolean result = Formatter.mail("roberto@gmail.com");
        assertTrue(result);
    }
}
