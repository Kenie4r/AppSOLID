package Utils;

import org.junit.jupiter.api.Test;
import org.kodigo.Utils.UtilsListas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilListasTest {

    @Test
    void sobrepasaIndexTest(){
        List<Integer> list = Arrays.asList(1,2,3);
        assertAll(()->{
            assertTrue(UtilsListas.sobrepasaIndex(1,list));
            assertFalse(UtilsListas.sobrepasaIndex(4,list));
        });
    }

    @Test
    void añadirAListaTest() {
        List<Integer> list = new ArrayList<>();
        UtilsListas.añadirALista(1,list);
        assertTrue(list.size()>0);
    }
}
