package Auxiliares;
import java.util.*;
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
        System.out.printf("                                Libros  (%-10s)                      %n",ClientRepository.clientArrayList.get(indiceCliente).getCLientName());
        System.out.printf("----------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-30s | %-10s | %-6s | %-14s |%n","Puesto", "Título", "Autor", "Año", "ISBN");
        System.out.printf("----------------------------------------------------------------------%n");

        for (int i = 0; i < ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.size(); i++) {
            System.out.printf("| %-6s | %-30s | %-10s | %-2s/%-2s/%-2s | %-14s |%n", i+1, ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getTitle(), ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getAuthor(), ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getDay(),ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getMonth(),ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getPublishDate().getYear(), ClientRepository.clientArrayList.get(indiceCliente).borrowedBooks.get(i).getISBN());
            System.out.printf("----------------------------------------------------------------------%n");
        }
    }

    public static void showTransactionsClient(int indiceDeCliente){
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites  (%-10s)                      %n",ClientRepository.clientArrayList.get(indiceDeCliente).getCLientName());
        System.out.printf("---------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-10s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("----------------------------------------------------------------------------------------------%n");

        for (int i = 0; i < ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.size(); i++) {
            System.out.printf("| %-6s | %-10s | %-30s | %-3s/%-3s/%-3s | %-14s |%n", i+1, ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getType(), ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowedBook().getTitle(), ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getDay(),ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getMonth(),ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getBorrowDate().getYear(), ClientRepository.clientArrayList.get(indiceDeCliente).clientTransactions.get(i).getTransactionID());
            System.out.printf("----------------------------------------------------------------------------------------------%n");
        }
    }
    public static void showTransactionsDate(Date bottomDate, Date topDate){
        System.out.println();
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites (Fecha)                       %n");
        System.out.printf("------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-4s | %-14s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("------------------------------------------------------------------------------------%n");
        int comparacionBottom,comparacionTop;
        for (int i = 0; i < Transactionrepository.transactionArrayList.size(); i++) {
            comparacionBottom = bottomDate.compareTo(Transactionrepository.transactionArrayList.get(i).getBorrowDate());
            comparacionTop = topDate.compareTo(Transactionrepository.transactionArrayList.get(i).getBorrowDate());
            if (comparacionBottom>0 && comparacionTop<0){
                System.out.printf("| %-6s | %-10s | %-30s | %-4s | %-14s |%n", i+1, Transactionrepository.transactionArrayList.get(i).getType(), Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle(), Transactionrepository.transactionArrayList.get(i).getBorrowDate(), Transactionrepository.transactionArrayList.get(i).getTransactionID());
                System.out.printf("----------------------------------------------------------------------------%n");
            }
        }
    }
    public static void showTransactionsBook(int indice){
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("                                Tramites   (Libro)                     %n");
        System.out.printf("---------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-10s | %-30s | %-6s | %-13s |%n","Puesto", "Type", "Book", "Fecha", "ID");
        System.out.printf("----------------------------------------------------------------------------------%n");
        for (int i = 0; i < Transactionrepository.transactionArrayList.size(); i++) {
            if (BookRepository.libraryBooks.get(indice).getTitle() == Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle()){
                System.out.printf("| %-6s | %-10s | %-30s | %-2s/%-2s/%-2s | %-14s |%n", i+1, Transactionrepository.transactionArrayList.get(i).getType(), Transactionrepository.transactionArrayList.get(i).getBorrowedBook().getTitle(), Transactionrepository.transactionArrayList.get(i).getBorrowDate().getDay(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getMonth(),Transactionrepository.transactionArrayList.get(i).getBorrowDate().getYear(), Transactionrepository.transactionArrayList.get(i).getTransactionID());
                System.out.printf("--------------------------------------------------------------------------------%n");
            }
        }
    }
}
