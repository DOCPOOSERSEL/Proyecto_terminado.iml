package Auxiliares;

import Controllers.*;
import Proyector.User;
import Repositories.UserRepository;

import java.util.Date;
import java.util.Scanner;


public class Starter {
    static Scanner sc = new Scanner(System.in);
    static int opcion, opcion2, userNum;
    static boolean flandelimon = true;
    public static void startProgram(){
        Repositories.Seeder.seederMetodo();

        do {
            MenuHolder.menuDeinicioDeSeccion();
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion != 1 && opcion != 2 && opcion != 3 ) ;
        do {
            switch (opcion){
                case 1:
                    userNum = LogInController.adminLogIn();
                    do {
                        MenuHolder.menuDeInicioManual();
                        opcion2 = sc.nextInt();
                    } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4 && opcion2 != 5 ) ;
                    if (opcion2 == 1) {
                        AuthorController.authorMetodo(UserRepository.adminsArrayList.get(userNum));
                    } else if (opcion2 == 2) {
                        BookController.bookMetodo(UserRepository.adminsArrayList.get(userNum));
                    } else if (opcion2 == 3) {
                        ClientController.metodoClientController(UserRepository.adminsArrayList.get(userNum));
                    } else if (opcion2 == 4) {
                        if (UserRepository.adminsArrayList.get(userNum).getSuperAdmin() == flandelimon){
                            AdminController.adminsCRUD();
                        }else{
                            System.out.println("Sin Autorizacion");
                        }
                    } else {
                        System.out.println("Buenas noches chavales");
                        flandelimon = false;
                    }
                    break;
                case 2:
                    userNum = LogInController.userLogIn();
                    do {
                        MenuHolder.menuMostrarOpcionesUsers();
                        opcion2=sc.nextInt();
                        sc.nextLine();
                    }while(opcion2 != 1 && opcion2 != 2 && opcion2 != 3);
                    switch (opcion2){
                        case 1:
                            MenuHolder.menuBookShowLibraryBooks();
                            break;
                        case 2:
                            showUserTransactions(UserRepository.userArrayList.get(userNum),userNum);
                            break;
                        case 3:
                            System.out.println("Buenas noches chavales");
                            flandelimon = false;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Buenas noches");
                    flandelimon = false;
                    break;
            }
        }while (flandelimon);
    }

    public static void showUserTransactions(User loggedInAcount,int userNum){
        int op1;
        boolean regresar=true;
        do {
            do {
                MenuHolder.menuMostrarOpcionesUsersTransaccions();
                op1 = sc.nextInt();
                sc.nextLine();
            }while(op1>3 || op1<1);
            switch (op1){
                case 1:
                    TransaccionTransaccions.showTransactionsClient(userNum);
                    break;
                case 2:
                    int auxntemp;
                    Date topDate = new Date();
                    Date bottomDate= new Date();
                    System.out.println("> > Ingreses el rango de fechas < <");
                    System.out.println("> > 1° Fecha < <");
                    System.out.printf(">> Dia: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    topDate.setDate(auxntemp);
                    System.out.printf(">> Mes: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    topDate.setMonth(auxntemp);
                    System.out.printf(">> Año: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    topDate.setYear(auxntemp);
                    System.out.println("> > 2° Fecha < <");
                    System.out.printf(">> Dia: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    bottomDate.setDate(auxntemp);
                    System.out.printf(">> Mes: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    bottomDate.setMonth(auxntemp);
                    System.out.printf(">> Año: ");
                    auxntemp = sc.nextInt();
                    sc.nextLine();
                    bottomDate.setYear(auxntemp);
                    TransaccionTransaccions.showTransactionsDateUser(loggedInAcount,bottomDate,topDate);
                    break;
                case 3:
                    regresar=false;
                    break;
            }
        }while(regresar);
    }
}
