package org.kodigo.Utils;

import java.io.IOException;

public class ScreenCleaner {
    public static void cleanScreen(){
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","cls");
        try {
            processBuilder.inheritIO().start().waitFor();
        } catch (InterruptedException e) {
        } catch (IOException e) {
        }
    }
}
