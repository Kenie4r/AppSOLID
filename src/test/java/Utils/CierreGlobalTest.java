package Utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kodigo.Utils.CierreGlobal;

import static org.junit.jupiter.api.Assertions.assertAll;

public class CierreGlobalTest {
    @Test
    @Disabled
    void testCierre(){
        assertAll(()->{
            CierreGlobal.cerrarAplicacion();
        });
    }
}
