package Proyector;
import java.util.*;
import Controllers.*;
import Auxiliares.MenuHolder;
import Repositories.Seeder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, opcion2;
        boolean flandelimon = true;

        do {
            MenuHolder.menuDeInicio();
            opcion = sc.nextInt();
        } while (opcion != 1 && opcion != 2 && opcion != 3 ) ;

        do {
            switch (opcion){
                case 1:
                    Repositories.Seeder.seederMetodo();
                    do {
                        sc.nextLine();
                        MenuHolder.menuDeInicioManual();
                        opcion2 = sc.nextInt();
                    } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4 ) ;
                    if (opcion2 == 1) {
                        AuthorController.authorMetodo();
                    } else if (opcion2 == 2) {
                        BookController.bookMetodo();
                    } else if (opcion2 == 3) {
                        ClientController.metodoClientController();
                    } else if (opcion2 == 4) {
                        System.out.println("Buenas noches chavales");
                        flandelimon = false;
                    }
                    break;
                case 2:

                    do {
                        sc.nextLine();
                        MenuHolder.menuDeInicioManual();
                        opcion2 = sc.nextInt();
                    } while (opcion2 != 1 && opcion2 != 2 && opcion2 != 3 && opcion2 != 4 ) ;

                    if (opcion2 == 1) {
                        AuthorController.authorMetodo();
                    } else if (opcion2 == 2) {
                        BookController.bookMetodo();
                    } else if (opcion2 == 3) {
                        ClientController.metodoClientController();
                    } else if (opcion2 == 4) {
                        System.out.println("Buenas noches chavales");
                        flandelimon = false;
                    }
                    break;
                case 3:
                    System.out.println("Buenas noches");
                    flandelimon = false;
                    break;
            }
        }while (flandelimon);

    }
}