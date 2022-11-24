package org.kodigo.Utils;

import java.util.Scanner;

public class ConsoleScanner {
    private static Scanner scan = new Scanner(System.in);

    public static Double getDouble(){
        double value = 0;
        while(true){
            try{
                String str =scan.nextLine();
                value = Double.parseDouble(str);
                break;
            }catch (NumberFormatException ex){
                System.out.println("El dato ingresado no es un número");
            }
        }
        return value;
    }

    public static String getString(){
        String value = scan.nextLine();
        return value;
    }
    //Validacion para evitar String Vacios

    public static Integer getInteger(){
        int value = 0;
        while(true){
            try{
                String str =scan.nextLine();
                value = Integer.parseInt(str);
                break;
            }catch (NumberFormatException ex){
                System.out.println("El dato ingresado no es un número");
            }
        }
        return value;
    }

    public static void closeScanner(){
        scan.close();
    }

    public static String getSingleString(){
        String value = scan.next();
        scan.nextLine();
        return value;
    }
}
