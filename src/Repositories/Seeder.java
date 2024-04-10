package Repositories;
import Auxiliares.Password;
import Auxiliares.Permissions;
import Proyector.*;

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
        libro1.Book("456-456","Bacas Baqueras","Sergio",bookDate1,true);
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
        libro2.Book("777-776","Biblia 2: El regreso de jesus","Martin",bookDate2,true);
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
        libro3.Book("326-556","Manual Para Romper Una Tele","Guillermo",bookDate3,true);
        author3.authorBooks.add(libro3);
        //Meterlos a su repositorio3
        BookRepository.libraryBooks.add(libro3);
        AuthorRepository.authorArrayList.add(author3);



        //Cliente1
        User client1 = new User();
        Date clientDate1 = new Date(2005,5,8);
        client1.setProfileUser("Candido","Ortega",clientDate1, Password.hashString("poomaster"));
        UserRepository.userArrayList.add(client1);
        //Cliente2
        User client2 = new User();
        Date clientDate2 = new Date(1456,9,13);
        client2.setProfileUser("John","Cena",clientDate2,Password.hashString("nomepuedesver"));
        UserRepository.userArrayList.add(client2);
        //Cliente3
        User client3 = new User();
        Date clientDate3 = new Date(1999,12,29);
        client3.setProfileUser("Lolita","Ayala",clientDate3,Password.hashString("silvarrera"));
        UserRepository.userArrayList.add(client3);

        //Admin1
        Admins newAdmin1 = new Admins();
        Date AdminDate1 = new Date(2005,3,9);
        newAdmin1.setProfileUser("Sergio","Rodriguez",AdminDate1, Password.hashString("contraseña"));
        newAdmin1.setSuperAdmin(true);
        UserRepository.adminsArrayList.add(newAdmin1);
        //Admin2
        Admins newAdmin2 = new Admins();
        Date AdminDate2 = new Date(2005,9,23);
        newAdmin2.setProfileUser("Poncho","ponchito",AdminDate2, Password.hashString("123"));
        newAdmin2.adminPermissions.add(Permissions.WRITE);
        UserRepository.adminsArrayList.add(newAdmin2);
    }
}
