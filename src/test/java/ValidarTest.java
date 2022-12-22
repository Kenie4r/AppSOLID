import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.kodigo.Utils.Validar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidarTest {

    @Test
    public void testForNumbers(){
        List<String> numbersForTesting = new ArrayList<>();
        int i = 0;
        while(i<100){
            numbersForTesting.add(String.valueOf(i));
            i++;
        }

        for (String num :
                numbersForTesting) {
            assertTrue(Validar.esNumero(num));
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {""," ","a","V","v","!","@","-"})
    public void testForNotNumbers(String notNum){
        assertFalse(Validar.esNumero(notNum));
    }
}
