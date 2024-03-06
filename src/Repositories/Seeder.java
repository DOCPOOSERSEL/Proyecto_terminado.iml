package Repositories;
import Proyector.*;
import Controllers.*;
import Auxiliares.*;

import java.util.Date;

public class Seeder {

    public static void seederMetodo(){
        //Autor
        Author author1 = new Author();
        Date authorDate1 = new Date(2005,3,9);
        author1.setProfileAuthorCompleto("Sergio","Adalid",authorDate1);
        //Libro
        Book libro1 = new Book();
        Date bookDate1 = new Date(2005,3,10);
        libro1.bookCreator("456-456","Bacas Baqueras","Sergio",bookDate1,true);
        author1.authorBooks.add(libro1);
        //Meterlos a su repositorio
        BookRepository.libraryBooks.add(libro1);
        AuthorRepository.authorArrayList.add(author1);

        //Autor2
        Author author2 = new Author();
        Date authorDate2 = new Date(1956,7,14);
        author2.setProfileAuthorCompleto("Martin","Lutero",authorDate2);
        //Libro2
        Book libro2 = new Book();
        Date bookDate2 = new Date(2000,9,25);
        libro2.bookCreator("777-776","Biblia 2: El regreso de jesus","Martin",bookDate2,true);
        author2.authorBooks.add(libro2);
        //Meterlos a su repositorio2
        BookRepository.libraryBooks.add(libro2);
        AuthorRepository.authorArrayList.add(author2);

        //Autor3
        Author author3 = new Author();
        Date authorDate3 = new Date(2002,4,27);
        author3.setProfileAuthorCompleto("Guillermo","Valdez",authorDate3);
        //Libro3
        Book libro3 = new Book();
        Date bookDate3 = new Date(2023,9,7);
        libro3.bookCreator("326-556","Manual Para Romper Una Tele","Guillermo",bookDate3,true);
        author3.authorBooks.add(libro3);
        //Meterlos a su repositorio3
        BookRepository.libraryBooks.add(libro3);
        AuthorRepository.authorArrayList.add(author3);



        //Cliente1
        Client client1 = new Client();
        Date clientDate1 = new Date(2005,5,8);
        client1.setProfileClient("Candido","Ortega",clientDate1);
        ClientRepository.clientArrayList.add(client1);
        //Cliente2
        Client client2 = new Client();
        Date clientDate2 = new Date(1456,9,13);
        client2.setProfileClient("John","Cena",clientDate2);
        ClientRepository.clientArrayList.add(client2);
        //Cliente3
        Client client3 = new Client();
        Date clientDate3 = new Date(1999,12,29);
        client3.setProfileClient("Lolita","Ayala",clientDate3);
        ClientRepository.clientArrayList.add(client3);

    }
}
