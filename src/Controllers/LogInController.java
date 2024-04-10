package Controllers;

import Auxiliares.MenuHolder;
import Auxiliares.Password;
import Repositories.UserRepository;

import java.util.Scanner;

public class LogInController {
    static int userNum;
    static String auxs;
    static Scanner sc = new Scanner(System.in);
    public static int adminLogIn(){
        do {
            do {
                MenuHolder.menuDeSeleccionDeAdmin();
                userNum = sc.nextInt();
                sc.nextLine();
                userNum--;
            }while(userNum>UserRepository.adminsArrayList.size() || userNum<0);
            System.out.println("Ingrese la contraseña");
            System.out.print(">> ");
            auxs = sc.nextLine();
            if (Password.hashString(auxs).equals(UserRepository.adminsArrayList.get(userNum).getPassword())){
                System.out.println("Seccion iniciada con exito!");
            }else {
                System.out.println("Cuenta equivocada o contraseña incorrecta");
            }
        }while(!Password.hashString(auxs).equals(UserRepository.adminsArrayList.get(userNum).getPassword()));
        return userNum;
    }
    public static int userLogIn(){
        do {
            do {
                MenuHolder.menuDeSeleccionDeUser();
                userNum = sc.nextInt();
                sc.nextLine();
                userNum--;
            }while(userNum>UserRepository.userArrayList.size() || userNum<0);
            System.out.println("Ingrese la contraseña");
            System.out.print(">> ");
            auxs = sc.nextLine();
            if (Password.hashString(auxs).equals(UserRepository.userArrayList.get(userNum).getPassword())){
                System.out.println("Seccion iniciada con exito!");
            }else {
                System.out.println("Cuenta equivocada o contraseña incorrecta");
            }
        }while(!Password.hashString(auxs).equals(UserRepository.userArrayList.get(userNum).getPassword()));
        return userNum;
    }
}
