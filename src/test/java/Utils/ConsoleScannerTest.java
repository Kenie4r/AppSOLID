package Utils;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kodigo.Utils.ConsoleScanner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleScannerTest {
    @Test
    @Disabled
    void testConsoleScanner(){
        System.out.println("Ingrese: prueba");
        assertEquals("prueba", ConsoleScanner.getSingleString());
        System.out.println("Ingrese: pruebas consola");
        assertEquals("pruebas consola",ConsoleScanner.getString());
        System.out.println("Ingrese: 10");
        assertEquals(10,ConsoleScanner.getInteger());
        System.out.println("Ingrese: 10");
        assertEquals(10,ConsoleScanner.getDouble());
        assertAll(ConsoleScanner::closeScanner);
    }
}
