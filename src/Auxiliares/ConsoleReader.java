package Auxiliares;

import java.util.Scanner;

public class ConsoleReader {
    static Scanner sc = new Scanner(System.in);

    public static int validatePositiveInt(String mesage){
        int auxn;
        do {
            System.out.println(mesage);
            System.out.print(">> ");
            auxn = sc.nextInt();
            sc.nextLine();
        }while (auxn<0);
        return auxn;
    }
    public static String readString(String mesage){
        String auxs;
        System.out.println(mesage);
        System.out.print(">> ");
        auxs = sc.nextLine();
        return auxs;
    }
    public static boolean validateString(String string1, String string2){
        return string1.equals(string2);
    }
}
