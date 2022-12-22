package Utils;

import org.junit.jupiter.api.Test;
import org.kodigo.Utils.Parseador;
import org.kodigo.Utils.Validar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseadorTest {

    @Test
    public void testParsearAIndex(){
        List<String> numbersForTesting = new ArrayList<>();
        int i = 0;
        while(i<100){
            numbersForTesting.add(String.valueOf(i));
            i++;
        }

        for (String num :
                numbersForTesting) {
            assertEquals(numbersForTesting.indexOf(num), Parseador.parsearAIndex(num),0);
        }
    }
}
