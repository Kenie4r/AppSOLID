package org.kodigo.Class;

import java.util.Scanner;

public class ConsoleScanner {
    private static Scanner scan = new Scanner(System.in);

    public static Double getDouble(){
        double value = scan.nextDouble();
        scan.nextLine();
        return scan.nextDouble();
    }

    public static String getString(){
        String value = scan.nextLine();
        return value;
    }

    public static Integer getInteger(){
        int value = scan.nextInt();
        scan.nextLine();
        return value;
    }

    public static void closeScanner(){
        scan.close();
    }
}
