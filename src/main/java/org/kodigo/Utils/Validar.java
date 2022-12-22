package org.kodigo.Utils;

public class Validar {
    public static boolean esNumero(String string){
        String regex = "^[0-9]+$";
        return string.matches(regex);
    }
}
