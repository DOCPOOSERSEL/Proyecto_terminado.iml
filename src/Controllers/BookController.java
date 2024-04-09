package Controllers;
import Auxiliares.MenuHolder;
import Auxiliares.Permissions;
import Proyector.*;
import Repositories.*;
import java.util.*;

public class BookController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn,indice=0;
    static String auxs;
    static boolean checkTrue=true;

    public static void bookMetodo(Admins loggedInAccount) {
        do {
            do { //Menu Principal de libros
               MenuHolder.menuBookPrincipal();
                pildora = sc.nextInt();
                if (pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5){
                    System.out.println("Nah uh");
                }
            }while(pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5);

            switch (pildora){
                case 1: //Crear un libro
                    if (AuthorRepository.authorArrayList.isEmpty()){
                        System.out.println("No hay autores disponibles");
                        System.out.printf(" %-10s \n","------------------");
                        break;
                    }else if (loggedInAccount.adminPermissions.contains(Permissions.WRITE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                        crearUnLibro();
                    }
                    break;
                case 2://Editar un libro
                    /*Comprobar si hay libros y seleccionar a editar*/
                    if (loggedInAccount.adminPermissions.contains(Permissions.WRITE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                        if (BookRepository.libraryBooks.isEmpty()){
                            System.out.println("No hay libros que se puedan editar");
                            break;
                        }else{
                            MenuHolder.menuBookShowLibraryBooks();
                            do {
                                System.out.printf(">> Que libro desea editar: ");
                                indice = sc.nextInt();
                                indice--;
                            }while (indice> BookRepository.libraryBooks.size() || indice<=0);
                        }
                        editarUnLibro();
                    }else{
                        System.out.println("Sin Autorizacion");
                    }
                    break;
                case 3:
                    if (loggedInAccount.adminPermissions.contains(Permissions.DELETE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                        do {
                            MenuHolder.menuBookShowLibraryBooks();
                            System.out.printf(">> Seleccione el libro a eliminar: ");
                            auxn= sc.nextInt();
                            sc.nextLine();
                            auxn--;
                        }while(auxn> BookRepository.libraryBooks.size() || auxn <0);
                        if (BookRepository.libraryBooks.get(auxn).getAvailable() == checkTrue){
                            for (int i=0 ; i<AuthorRepository.authorArrayList.size();i++){
                                if (AuthorRepository.authorArrayList.get(i).getProfileAuthorName() == BookRepository.libraryBooks.get(auxn).getAuthor()){
                                    for (int j=0; j<AuthorRepository.authorArrayList.get(i).authorBooks.size();j++){
                                        if (AuthorRepository.authorArrayList.get(i).authorBooks.get(j).getAuthor() == BookRepository.libraryBooks.get(auxn).getAuthor() ){
                                            AuthorRepository.authorArrayList.get(i).authorBooks.remove(j);
                                        }
                                    }
                                }
                            }
                            BookRepository.libraryBooks.remove(auxn);
                        }
                    }else{
                        System.out.println("Sin Autorizacion");
                    }
                    break;
                case 4://mostrar libros
                    if (loggedInAccount.adminPermissions.contains(Permissions.READ)|| loggedInAccount.getSuperAdmin()==checkTrue){
                        MenuHolder.menuBookShowLibraryBooks();
                    }else{
                        System.out.println("Sin Autorizacion");
                    }
                    break;
                case 5:
                    System.out.println("Regresando al menu anterior");
                    break;
            }
        }while (pildora != 5 );
    }

    public static void crearUnLibro(){
        Book bok = new Book();
        String Title, Author, ISBN;
        Date publishedDate = new Date();
        int indexAuthor;
        /*Seleccionar author*/
        MenuHolder.menuBookSeleccionarAuthorParaCrearLibro();
        do {
            System.out.printf(">> Selecciona al author: ");
            indexAuthor = sc.nextInt();
            sc.nextLine();
        }while(indexAuthor > AuthorRepository.authorArrayList.size() || indexAuthor<=0);
        indexAuthor--;
        Author = AuthorRepository.authorArrayList.get(indexAuthor).getProfileAuthorName();

        /*Resto de datos*/
        System.out.printf("Ingrese El Titulo:  ");
        Title = sc.nextLine();
        System.out.printf("Ingrese El ISBN:  ");
        ISBN = sc.nextLine();
        sc.nextLine();
        System.out.println("> > Fecha < < ");
        System.out.printf("Ingrese El Dia:  ");
        auxn = sc.nextInt();
        sc.nextLine();
        publishedDate.setDate(auxn);
        System.out.printf("Ingrese El Mes:  ");
        auxn = sc.nextInt();
        sc.nextLine();
        publishedDate.setMonth(auxn);
        System.out.printf("Ingrese El Año:  ");
        auxn = sc.nextInt();
        sc.nextLine();
        publishedDate.setYear(auxn);
        Boolean available=true;
        bok.Book(ISBN,Title,Author,publishedDate,available);
        AuthorRepository.authorArrayList.get(indexAuthor).authorBooks.add(bok);
        BookRepository.libraryBooks.add(bok);
    }
    public static void editarUnLibro(){
        do {/*Menu de edicion*/
            MenuHolder.menuBookEdit();
            System.out.printf(">> ");
            auxn = sc.nextInt();
            sc.nextLine();
        }while(auxn>5 || auxn<=0);
        switch (auxn){
            case 1:
                System.out.printf(">> Titulo: ");
                auxs = sc.nextLine();
                BookRepository.libraryBooks.get(indice).setTitle(auxs);
                break;
            case 2:
                System.out.printf(">> ISBN: ");
                auxs = sc.nextLine();
                BookRepository.libraryBooks.get(indice).setISBN(auxs);
                break;
            case 3:
                Date modifiedDate = new Date();
                System.out.println(" < < Fecha > > ");

                System.out.printf(">> Dia: ");
                auxn = sc.nextInt();
                modifiedDate.setDate(auxn);

                System.out.printf(">> Mes: ");
                auxn = sc.nextInt();
                modifiedDate.setMonth(auxn);

                System.out.printf(">> Año: ");
                auxn = sc.nextInt();
                modifiedDate.setYear(auxn);

                BookRepository.libraryBooks.get(indice).setPublishDate(modifiedDate);
                break;
            case 4://Cambiar el Autor de un libro
                String autorTemp,autorTemp2;
                int i=0,j=0;
                do {/*nuevo autor*/
                    MenuHolder.menuBookSeleccionarAuthorParaCrearLibro();
                    System.out.printf(">> Seleccionar nuevo autor: ");
                    auxn = sc.nextInt();
                    sc.nextLine();
                    auxn--;
                }while (auxn>AuthorRepository.authorArrayList.size() || auxn<0);
                auxs = BookRepository.libraryBooks.get(indice).getAuthor();
                do {/*Nombre de el author que coinsida con el del libro*/
                    autorTemp = AuthorRepository.authorArrayList.get(i).getProfileAuthorName();
                    i++;
                }while(auxs != autorTemp);
                auxs = BookRepository.libraryBooks.get(indice).getTitle();
                do {
                    autorTemp2 = AuthorRepository.authorArrayList.get(i).authorBooks.get(j).getTitle();
                    j++;
                }while(auxs != autorTemp2);
                /*Logica de remplaso y cambio de autor en el objeto*/
                AuthorRepository.authorArrayList.get(auxn).authorBooks.add(AuthorRepository.authorArrayList.get(i).authorBooks.get(j));
                AuthorRepository.authorArrayList.get(i).authorBooks.get(j).setAuthor(AuthorRepository.authorArrayList.get(auxn).getProfileAuthorName());
                AuthorRepository.authorArrayList.get(i).authorBooks.remove(j);
                break;
            case 5:
                System.out.println("Regresando al menu anterior");
                break;
        }
    }
}
