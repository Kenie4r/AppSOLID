package org.kodigo.Utils;

public class PauseScreen {
    public static void pause(int segundos){
        System.out.println("Pausado");
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
