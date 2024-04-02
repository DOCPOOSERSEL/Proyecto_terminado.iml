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

    public static void transactionFuncion(){
        do {
            do {
                MenuHolder.menuTransaccionInicio();
                indice1 = sc.nextInt();
                sc.nextLine();
            }while(indice1>4 || indice1<=0);
            switch (indice1){
                case 1://Sacar un libro
                    int dateseter=0;
                    Date transDate= new Date();
                    Transaction newTransaction = new Transaction();
                    do {
                        MenuHolder.menuEnseñarClientesParaTransacciones();
                        System.out.printf(">> Ingresa el Cliente:");
                        indice2 = sc.nextInt();
                        sc.nextLine();
                        indice2--;
                    }while (indice2>ClientRepository.clientArrayList.size() || indice2<0);
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

                    System.out.println("> > Fecha de transaccion < <");
                    System.out.printf("Ingrese el dia: ");
                    dateseter = sc.nextInt();
                    sc.nextLine();
                    transDate.setDate(dateseter);
                    System.out.printf("Ingrese el Mes: ");
                    dateseter = sc.nextInt();
                    sc.nextLine();
                    transDate.setMonth(dateseter);
                    System.out.printf("Ingrese el Año: ");
                    dateseter = sc.nextInt();
                    sc.nextLine();
                    transDate.setYear(dateseter);

                    BookRepository.libraryBooks.get(indice3).setAvailable(checkFalse);
                    auxs = TransaccionTransaccions.newTransactionID();
                    newTransaction.createNewTransaction(auxs,"Prestamo",ClientRepository.clientArrayList.get(indice2),BookRepository.libraryBooks.get(indice3),transDate);
                    Transactionrepository.transactionArrayList.add(newTransaction);
                    ClientRepository.clientArrayList.get(indice2).borrowedBooks.add(BookRepository.libraryBooks.get(indice3));
                    ClientRepository.clientArrayList.get(indice2).clientTransactions.add(newTransaction);

                    break;

                case 2://Regresar un libro
                    int returnDateseter=0;
                    Date returnDate = new Date();
                    Transaction returnTransaction = new Transaction();
                    do {
                        MenuHolder.menuEnseñarClientesParaTransacciones();
                        System.out.printf(">> Ingresa el Cliente:");
                        indice2 = sc.nextInt();
                        sc.nextLine();
                        indice2--;
                    }while (indice2>ClientRepository.clientArrayList.size() || indice2<0);
                    do {
                        TransaccionTransaccions.menuTransaccionesLibrosEnPosecionDeElCliente(indice2);
                        System.out.printf(">> Ingresa el Libro:");
                        indice3 = sc.nextInt();
                        sc.nextLine();
                        indice3--;
                    }while(indice3>ClientRepository.clientArrayList.get(indice2).borrowedBooks.size() || indice3<0);

//                    System.out.println("> > Fecha de transaccion < <");
//                    System.out.printf("Ingrese el dia: ");
//                    returnDateseter = sc.nextInt();
//                    sc.nextLine();
//                    returnDate.setDate(returnDateseter);
//                    System.out.printf("Ingrese el Mes: ");
//                    returnDateseter = sc.nextInt();
//                    sc.nextLine();
//                    returnDate.setMonth(returnDateseter);
//                    System.out.printf("Ingrese el Año: ");
//                    returnDateseter = sc.nextInt();
//                    sc.nextLine();
//                    returnDate.setYear(returnDateseter);

                    ClientRepository.clientArrayList.get(indice2).borrowedBooks.get(indice3).setAvailable(checkTrue);
                    auxs = TransaccionTransaccions.newTransactionID();
                    returnTransaction.createNewTransaction(auxs,"Regreso",ClientRepository.clientArrayList.get(indice2),ClientRepository.clientArrayList.get(indice2).borrowedBooks.get(indice3),returnDate);
                    ClientRepository.clientArrayList.get(indice2).borrowedBooks.remove(indice3);
                    ClientRepository.clientArrayList.get(indice2).clientTransactions.add(returnTransaction);
                    Transactionrepository.transactionArrayList.add(returnTransaction);
                    break;
                case 3://Mostrar las transacciones con filtro
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
                                }while(indice2>ClientRepository.clientArrayList.size() || indice2<0);
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
                case 4:
                    System.out.println("Regresando al menu anterior");
                    break;
            }
        }while(indice1 != 4);
    }
}
