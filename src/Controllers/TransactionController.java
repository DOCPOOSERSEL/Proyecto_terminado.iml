package Controllers;
import Proyector.*;
import Auxiliares.*;
import Repositories.*;
import java.util.*;

public class TransactionController {
    static int auxn,indice1,indice2,indice3;
    static String auxs;
    static boolean checkTrue = true, checkFalse=false;
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Runnable> actions = new HashMap<>();
    public static void transactionFuncion(Admins loggedInAccount){
        actions.put(1, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.WRITE) || loggedInAccount.getSuperAdmin()==checkTrue){
                createTransaction();
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(2, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.WRITE) || loggedInAccount.getSuperAdmin()==checkTrue){
                createReturnTransaction();
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(3, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.READ) || loggedInAccount.getSuperAdmin()==checkTrue){
                showClientTransactions();
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(4, () ->{
            System.out.println("Regresando al menu anterior");
        });
        do {
            do {
                MenuHolder.menuTransaccionInicio();
                indice1 = sc.nextInt();
                sc.nextLine();
            }while(indice1>4 || indice1<=0);
            actions.get(indice1).run();
        }while(indice1 != 4);
    }
    public static void createTransaction(){
        Date transDate= new Date();
        Transaction newTransaction = new Transaction();
        do {
            MenuHolder.menuEnseñarClientesParaTransacciones();
            System.out.printf(">> Ingresa el Cliente:");
            indice2 = sc.nextInt();
            sc.nextLine();
            indice2--;
        }while (indice2> UserRepository.userArrayList.size() || indice2<0);
        do {
            do {
                MenuHolder.menuBookShowLibraryBooks();
                System.out.printf(">> Ingresa el libro:");
                indice3 = sc.nextInt();
                sc.nextLine();
                indice3--;
            }while(indice3>BookRepository.libraryBooks.size() || indice3 < 0);
            if (checkFalse == BookRepository.libraryBooks.get(indice3).getAvailable()){
                System.out.println("Ese libro no esta disponible por favor escoje otro");
            }
        }while(BookRepository.libraryBooks.get(indice3).getAvailable() == checkFalse);
        BookRepository.libraryBooks.get(indice3).setAvailable(checkFalse);
        auxs = TransaccionTransaccions.newTransactionID();
        newTransaction.createNewTransaction(auxs,"Prestamo", UserRepository.userArrayList.get(indice2),BookRepository.libraryBooks.get(indice3),transDate);
        Transactionrepository.transactionArrayList.add(newTransaction);
        UserRepository.userArrayList.get(indice2).borrowedBooks.add(BookRepository.libraryBooks.get(indice3));
        UserRepository.userArrayList.get(indice2).clientTransactions.add(newTransaction);
    }
    public static void createReturnTransaction(){
        Date returnDate = new Date();
        Transaction returnTransaction = new Transaction();
        do {
            MenuHolder.menuEnseñarClientesParaTransacciones();
            System.out.printf(">> Ingresa el Cliente:");
            indice2 = sc.nextInt();
            sc.nextLine();
            indice2--;
        }while (indice2> UserRepository.userArrayList.size() || indice2<0);
        do {
            TransaccionTransaccions.menuTransaccionesLibrosEnPosecionDeElCliente(indice2);
            System.out.printf(">> Ingresa el Libro:");
            indice3 = sc.nextInt();
            sc.nextLine();
            indice3--;
        }while(indice3> UserRepository.userArrayList.get(indice2).borrowedBooks.size() || indice3<0);
        UserRepository.userArrayList.get(indice2).borrowedBooks.get(indice3).setAvailable(checkTrue);
        auxs = TransaccionTransaccions.newTransactionID();
        returnTransaction.createNewTransaction(auxs,"Regreso", UserRepository.userArrayList.get(indice2), UserRepository.userArrayList.get(indice2).borrowedBooks.get(indice3),returnDate);
        UserRepository.userArrayList.get(indice2).borrowedBooks.remove(indice3);
        UserRepository.userArrayList.get(indice2).clientTransactions.add(returnTransaction);
        Transactionrepository.transactionArrayList.add(returnTransaction);
    }
    public static void showClientTransactions(){
        do {
            do {
                MenuHolder.menuSeleccionarFiltroTransacciones();
                auxn = sc.nextInt();
                sc.nextLine();
            }while(auxn>4 || auxn<=0);
            switch (auxn){
                case 1://Filtro de clientes
                    do {
                        MenuHolder.menuEnseñarClientesParaTransacciones();
                        System.out.printf(">> Ingrese el cliente: ");
                        indice2 = sc.nextInt();
                        sc.nextLine();
                        indice2--;
                    }while(indice2> UserRepository.userArrayList.size() || indice2<0);
                    TransaccionTransaccions.showTransactionsClient(indice2);
                    break;
                case 2://Filtro de Fechas
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
                    TransaccionTransaccions.showTransactionsDate(bottomDate,topDate);
                    break;
                case 3://Fitro de libros
                    do {
                        MenuHolder.menuBookShowLibraryBooks();
                        System.out.printf(">> Ingresa la posicion: ");
                        indice2 = sc.nextInt();
                        sc.nextLine();
                        indice2--;
                    }while(indice2> BookRepository.libraryBooks.size() || indice2 <0);
                    TransaccionTransaccions.showTransactionsBook(indice2);
                    break;
                case 4:
                    System.out.println("Regresando al menu anterior");
                    break;

            }
        }while(auxn != 4);
    }
}