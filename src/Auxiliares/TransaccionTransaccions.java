package Auxiliares;
import java.util.*;

import Proyector.User;
import Repositories.*;

public class TransaccionTransaccions {
    static String auxs;
    public static String newTransactionID(){
        int auxn,auxn2;
        if (Transactionrepository.transactionArrayList.isEmpty()){
            auxs = stringGenerator();
        }else{
            do {
                auxs = stringGenerator();
                auxn=0;
                for (int i=0; i<Transactionrepository.transactionArrayList.size(); i++ ){
                    if (auxs == Transactionrepository.transactionArrayList.get(i).getTransactionID()){
                        auxn++;
                    }
                }
            }while(auxn>=1);
        }
        return auxs;
    }
    public static String stringGenerator(){
        final String Storage = "ABCDEFGHIJKLMNOPQRSTUVZWXYZabcdefghijklmnopqrstuvzwxyz";
        final int Idsize = 6;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Idsize;i++){
            double aleatorio= Math.random()*Storage.length();
            int posicion = (int) aleatorio;
            char letraporletra= Storage.charAt(posicion);
            sb.append(letraporletra);
        }
        return sb.toString();
    }

    public static void menuTransaccionesLibrosEnPosecionDeElCliente(int indiceCliente){
        System.out.println();
        System.out.printf("----------------------------------------------------------------------%n");
        System.out.printf("                                Libros  (%-10s)                      %n", UserRepository.userArrayList.get(indiceCliente).getUserName());
        System.out.printf("----------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-30s | %-10s | %-6s | %-14s |%n","Puesto", "Título", "Autor", "Año", "ISBN");
        System.out.printf("----------------------------------------------------------------------%n");

        for (int i = 0; i < UserRepository.userArrayList.get(indiceCliente).borrowedBooks.size(); i++) {
            System.out.printf("| %-6s | %-30s | %-10s | %-2s/%-2s/%-2s | %-14s |%n", i+1, UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getTitle(), UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getAuthor(), UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getDay(), UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getMonth(), UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getYear(), UserRepository.userArrayList.get(indiceCliente).borrowedBooks.get(i).getISBN());
            System.out.printf("----------------------------------------------------------------------%n");
        }
    }

    public static void showTransactionsClient(int indiceDeCliente){
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites  (%-10s)                      %n", UserRepository.userArrayList.get(indiceDeCliente).getUserName());
        System.out.printf("---------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-10s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("----------------------------------------------------------------------------------------------%n");

        for (int i = 0; i < UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.size(); i++) {
            System.out.printf("| %-6s | %-10s | %-30s | %-3s/%-3s/%-3s | %-14s |%n", i+1, UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getType(), UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowedBook().getTitle(), UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getDay(), UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getMonth(), UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getYear(), UserRepository.userArrayList.get(indiceDeCliente).clientTransactions.get(i).getTransactionID());
            System.out.printf("----------------------------------------------------------------------------------------------%n");
        }
    }
    public static void showTransactionsDate(Date bottomDate, Date topDate){
        System.out.println();
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites (Fecha)                       %n");
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-6s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("------------------------------------------------------------------------------------%n");
        int comparacionBottom,comparacionTop;
        for (int i = 0; i < Transactionrepository.transactionArrayList.size(); i++) {
            comparacionBottom = bottomDate.compareTo(Transactionrepository.transactionArrayList.get(i).getBorrowDate());
            comparacionTop = topDate.compareTo(Transactionrepository.transactionArrayList.get(i).getBorrowDate());
            if (comparacionBottom>0 && comparacionTop<0){
                System.out.printf("| %-6s | %-10s | %-30s | %-2s/%-2s/%-2s | %-14s |%n", i+1, Transactionrepository.transactionArrayList.get(i).getType(), Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle(), Transactionrepository.transactionArrayList.get(i).getBorrowDate().getDay(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getMonth(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getYear(), Transactionrepository.transactionArrayList.get(i).getTransactionID());
                System.out.printf("----------------------------------------------------------------------------%n");
            }
        }
    }
    public static void showTransactionsBook(int indice){
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites   (Libro)                     %n");
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-6s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("----------------------------------------------------------------------------------%n");
        for (int i = 0; i < Transactionrepository.transactionArrayList.size(); i++) {
            if (BookRepository.libraryBooks.get(indice).getTitle() == Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle()){
                System.out.printf("| %-6s | %-10s | %-30s | %-2s/%-2s/%-2s | %-14s |%n", i+1, Transactionrepository.transactionArrayList.get(i).getType(), Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle(), Transactionrepository.transactionArrayList.get(i).getBorrowDate().getDay(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getMonth(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getYear(), Transactionrepository.transactionArrayList.get(i).getTransactionID());
                System.out.printf("--------------------------------------------------------------------------------%n");
            }
        }
    }
    public static void showTransactionsDateUser(User loggedInAccount,Date bottomDate, Date topDate){
        System.out.println();
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites (Fecha)                       %n");
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-6s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("------------------------------------------------------------------------------------%n");
        int comparacionBottom,comparacionTop;
        for (int i = 0; i < loggedInAccount.clientTransactions.size(); i++) {
            comparacionBottom = bottomDate.compareTo(loggedInAccount.clientTransactions.get(i).getBorrowDate());
            comparacionTop = topDate.compareTo(loggedInAccount.clientTransactions.get(i).getBorrowDate());
            if (comparacionBottom>0 && comparacionTop<0){
                System.out.printf("| %-6s | %-10s | %-30s | %-2s/%-2s/%-2s | %-14s |%n", i+1, loggedInAccount.clientTransactions.get(i).getType(), loggedInAccount.clientTransactions.get(i).getBorrowedBook().getTitle(), loggedInAccount.clientTransactions.get(i).getBorrowDate().getDay(),loggedInAccount.clientTransactions.get(i).getBorrowDate().getMonth(),loggedInAccount.clientTransactions.get(i).getBorrowDate().getYear(), loggedInAccount.clientTransactions.get(i).getTransactionID());
                System.out.printf("----------------------------------------------------------------------------%n");
            }
        }
    }

}
