package org.kodigo.Utils;

public class CierreGlobal {
    public static void cerrarAplicacion(){
        ConsoleScanner.closeScanner();
        ScreenCleaner.cleanScreen();
        System.exit(0);
    }
}
