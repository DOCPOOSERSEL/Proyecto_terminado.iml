package Auxiliares;

import Repositories.AuthorRepository;
import Repositories.BookRepository;
import Repositories.UserRepository;

public class MenuHolder {
    //Menus de Inicio
    public static void menuDeInicio(){
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","Menu de Inicio");
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","1.-Iniciar");
        System.out.printf("| %-15s |\n","2.-Manual");
        System.out.printf("| %-15s |\n","3.-Finalizar");
        System.out.println("-------------------");
        System.out.printf(">> ");
    }
    public static void menuDeInicioManual(){
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","Menu");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Menu de Autor");
        System.out.printf("| %-20s |\n","2.-Menu de Libro");
        System.out.printf("| %-20s |\n","3.-Menu de Cliente");
        System.out.printf("| %-20s |\n","4.-Finalizar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }


    //Menus de author
    public static void menuAuthorOpcionesPrincipales(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Crear Autor");
        System.out.printf("| %-20s |\n","2.-Editar Autor");
        System.out.printf("| %-20s |\n","3.-Eliminar Autor");
        System.out.printf("| %-20s |\n","4.-Mostrar Autores");
        System.out.printf("| %-20s |\n","5.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }
    public static void menuAuthorSinLibros(){
        System.out.println("_____________________________________________________");
        System.out.printf("| %-50s |\n", "Autores");
        System.out.println("_____________________________________________________");
        System.out.printf("| %-10s |", "Nombre");
        System.out.printf("| %-10s |", "Apellido");
        System.out.printf("| %-21s |\n", "Fecha de nacimiento");
        for (int i = 0; i< AuthorRepository.authorArrayList.size()  ; i++){
            System.out.printf( "|%-2s %-10s",i+1 ,AuthorRepository.authorArrayList.get(i).getProfileAuthorName());
            System.out.printf(" %-10s |",AuthorRepository.authorArrayList.get(i).getProfileAuthorLastName());
            System.out.printf("| %-7s/%-7s/%-7s |\n",AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getDay(),AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getMonth(),AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getYear());
            System.out.println("_____________________________________________________");
        }
    }
    public static void menuAuthorConLibros(){
        System.out.println("________________________________________________________");
        System.out.printf("| %-50s |\n", "Autores");
        System.out.println("________________________________________________________");
        System.out.printf("| %-10s |", "Nombre");
        System.out.printf("| %-10s |", "Apellido");
        System.out.printf("| %-25s |\n", "Fecha de nacimiento");
        for (int i=0; i< AuthorRepository.authorArrayList.size()  ; i++){
            System.out.printf( "|%-2s %-10s",i+1 ,AuthorRepository.authorArrayList.get(i).getProfileAuthorName());
            System.out.printf(" %-10s  |",AuthorRepository.authorArrayList.get(i).getProfileAuthorLastName());
            System.out.printf("| %-7s/ %-7s/ %-7s|\n",AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getDay(),AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getMonth(),AuthorRepository.authorArrayList.get(i).getProfileAuthorBirthdate().getYear());
            if (AuthorRepository.authorArrayList.get(i).authorBooks.isEmpty()){
                System.out.println("________________________________________________________");
            }else {
                int temp = AuthorRepository.authorArrayList.get(i).authorBooks.size();
                for (int j = 0; j < temp ; j++) {
                    System.out.printf("|%-2s %-41s |\n",j+1, AuthorRepository.authorArrayList.get(i).authorBooks.get(j).getTitle());
                }
                System.out.println("_____________________________________________________");
            }
        }
    }
    public static void menuAuthorEdicion(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu de Edicion");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Nombre");
        System.out.printf("| %-20s |\n","2.-Apellido");
        System.out.printf("| %-20s |\n","3.-Fecha");
        System.out.printf("| %-20s |\n","4.-regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }

    //Libros controller
    public static void menuBookPrincipal(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Crear Libro");
        System.out.printf("| %-20s |\n","2.-Editar Libro");
        System.out.printf("| %-20s |\n","3.-Eliminar Libro");
        System.out.printf("| %-20s |\n","4.-Mostrar Libros");
        System.out.printf("| %-20s |\n","5.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }
    public static void menuBookSeleccionarAuthorParaCrearLibro(){
        System.out.println("> > Book Creator < <");
        System.out.printf(" %-10s \n","-----------------------------");
        System.out.printf("| %-26s |\n","Ingrese el autor del libro");
        System.out.printf(" %-10s \n","-----------------------------");
        for ( int i=0 ; i<AuthorRepository.authorArrayList.size(); i++ ){
            System.out.printf("|%-2s.- ",i+1);
            System.out.printf("%-22s |\n",AuthorRepository.authorArrayList.get(i).getProfileAuthorName());
        }
        System.out.printf(" %-10s \n","-----------------------------");
    }
    public static void menuBookShowLibraryBooks(){
        System.out.println();
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        System.out.printf("                                Libros  Chucho                      %n");
        System.out.printf("---------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-6s | %-30s | %-10s | %-10s | %-10s | %-14s |%n","Puesto", "Título", "Autor", "Abailable", "Año", "ISBN");
        System.out.printf("---------------------------------------------------------------------------------------------------%n");

        for (int i = 0; i < BookRepository.libraryBooks.size(); i++) {
            System.out.printf("| %-6s | %-30s | %-10s | %-10s | %-2s/%-2s/%-2s | %-14s |%n", i+1, BookRepository.libraryBooks.get(i).getTitle(), BookRepository.libraryBooks.get(i).getAuthor(), BookRepository.libraryBooks.get(i).getAvailable(), BookRepository.libraryBooks.get(i).getPublishDate().getDate(),BookRepository.libraryBooks.get(i).getPublishDate().getMonth(),BookRepository.libraryBooks.get(i).getPublishDate().getYear(), BookRepository.libraryBooks.get(i).getISBN());
            System.out.printf("---------------------------------------------------------------------------------------------------%n");
        }
    }
    public static void menuBookEdit(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu de Edicion");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Titulo");
        System.out.printf("| %-20s |\n","2.-ISBN");
        System.out.printf("| %-20s |\n","3.-Fecha");
        System.out.printf("| %-20s |\n","4.-Author");
        System.out.printf("| %-20s |\n","5.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }

    //User menus
    public static void menuInicioClient(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu de User");
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","1.-Transacciones");
        System.out.printf("| %-20s |\n","2.-Creacion/Edicion");
        System.out.printf("| %-20s |\n","3.-Enseñar");
        System.out.printf("| %-20s |\n","4.-Regresar");
        System.out.println("-------------------------");
        System.out.printf(">> ");
    }
    public static void menuCreacionEdicionClient(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu Creacion/Edicion");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Crear Usuario");
        System.out.printf("| %-20s |\n","2.-Editar Usuario");
        System.out.printf("| %-20s |\n","3.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }
    public static void menuEnseñarClientesConLibros(){
        System.out.println("______________________________________________________");
        System.out.printf("| %-50s |\n", "clientes");
        System.out.println("______________________________________________________");
        System.out.printf("| %-10s |", "Nombre");
        System.out.printf("| %-10s |", "Apellido");
        System.out.printf("| %-23s |\n", "Fecha de nacimiento");
        System.out.println("______________________________________________________");
        for (int i = 0; i< UserRepository.userArrayList.size()  ; i++){
            System.out.printf( "|%-2s %-10s",i+1 , UserRepository.userArrayList.get(i).getUserName());
            System.out.printf(" %-10s  |", UserRepository.userArrayList.get(i).getUserLastName());
            System.out.printf("| %-7s/%-7s7%7s |\n", UserRepository.userArrayList.get(i).getUserDateOfBirth().getDate(), UserRepository.userArrayList.get(i).getUserDateOfBirth().getMonth(), UserRepository.userArrayList.get(i).getUserDateOfBirth().getYear());
            if (UserRepository.userArrayList.get(i).borrowedBooks.isEmpty()){
                System.out.println("______________________________________________________");
            }else {
                for (int j = 0; j < UserRepository.userArrayList.get(i).borrowedBooks.size() ; j++) {
                    System.out.printf("|%-2s %-41s |\n",j+1, UserRepository.userArrayList.get(i).borrowedBooks.get(j).getTitle());
                }
                System.out.println("_____________________________________________________");
            }
        }
    }

    public static void menuParaSeleccionarUnClienteParaEditar(){
        System.out.println("> > Client Editor < <");
        System.out.printf(" %-10s \n","-------------------");
        for (int i = 0; i< UserRepository.userArrayList.size(); i++ ){
            System.out.printf("|%-2s.- ",i+1);
            System.out.printf("%-8s |\n", UserRepository.userArrayList.get(i).getUserName());
        }
        System.out.printf(" %-10s \n","-------------------");
    }

    public static void menuSeleccionarTipoDeEdicionCliente(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu de Edicion");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Nombre");
        System.out.printf("| %-20s |\n","2.-Apellido");
        System.out.printf("| %-20s |\n","3.-Fecha");
        System.out.printf("| %-20s |\n","4.-Eliminar");
        System.out.printf("| %-20s |\n","5.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }

    public static void menuDeConfirmacionEdicionClient(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Seguro que quiere editar");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.- Si");
        System.out.printf("| %-20s |\n","2.- No");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }

    //Transacciones
    public static void menuTransaccionInicio(){
        System.out.println("----------------------------------");
        System.out.printf("| %-30s |\n","Menu");
        System.out.println("----------------------------------");
        System.out.printf("| %-30s |\n","1.-Sacar un libro");
        System.out.printf("| %-30s |\n","2.-Regresar un libro");
        System.out.printf("| %-30s |\n","3.-Mostrar Transacciones");
        System.out.printf("| %-30s |\n","4.-Regresar");
        System.out.println("----------------------------------");
        System.out.printf(">> ");
    }
    public static void menuEnseñarClientesParaTransacciones(){
        System.out.printf(" %-10s \n","-----------------------");
        System.out.printf("%-14s\n","Clientes para transacciones");
        System.out.printf(" %-10s \n","-----------------------");
        for (int i = 0; i< UserRepository.userArrayList.size(); i++ ){
            System.out.printf("|%-2s.- ",i+1);
            System.out.printf("%-12s |\n", UserRepository.userArrayList.get(i).getUserName());
        }
        System.out.printf(" %-10s \n","-----------------------");
    }
    public static void menuSeleccionarFiltroTransacciones(){
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","Filtro");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Por Cliente");
        System.out.printf("| %-20s |\n","2.-Por Fecha");
        System.out.printf("| %-20s |\n","3.-Por Libro");
        System.out.printf("| %-20s |\n","4.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }

    //Menu de LogIn
    public static void menuDeinicioDeSeccion(){
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","Menu de Inicio de seccion");
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","1.-Administrador");
        System.out.printf("| %-15s |\n","2.-Usuario");
        System.out.printf("| %-15s |\n","3.-Finalizar");
        System.out.println("-------------------");
        System.out.printf(">> ");
    }
    public static void menuDeSeleccionDeAdmin(){
        System.out.printf(" %-10s \n","-----------------------");
        System.out.printf("| %-14s |\n","Administradores");
        System.out.printf(" %-10s \n","-----------------------");
        for (int i = 0; i< UserRepository.adminsArrayList.size(); i++ ){
            System.out.printf("|%-2s.- ",i+1);
            System.out.printf("%-12s    |\n", UserRepository.adminsArrayList.get(i).getUserName());
        }
        System.out.printf(" %-10s \n","-----------------------");
        System.out.print(">> ");
    }
    public static void menuDeSeleccionDeUser(){
        System.out.printf(" %-10s \n","-----------------------");
        System.out.printf("%-14s\n","Users");
        System.out.printf(" %-10s \n","-----------------------");
        for (int i = 0; i< UserRepository.userArrayList.size(); i++ ){
            System.out.printf("|%-2s.- ",i+1);
            System.out.printf("%-12s |\n", UserRepository.userArrayList.get(i).getUserName());
        }
        System.out.printf(" %-10s \n","-----------------------");
        System.out.print(">> ");
    }
//Admins
    public static void menuDeCreacionDeAdmins(){
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","Menu de Administracion");
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","1.-Crear");
        System.out.printf("| %-15s |\n","2.-Editar");
        System.out.printf("| %-15s |\n","3.-Eliminar");
        System.out.printf("| %-15s |\n","4.-Salir");
        System.out.println("-------------------");
        System.out.printf(">> ");
    }
    public static void menuDeEdicionAdmin(){
        System.out.println("-------------------------");
        System.out.printf("| %-20s |\n","Menu de Edicion");
        System.out.println("------------------------");
        System.out.printf("| %-20s |\n","1.-Nombre");
        System.out.printf("| %-20s |\n","2.-Apellido");
        System.out.printf("| %-20s |\n","3.-Fecha");
        System.out.printf("| %-20s |\n","4.-Permisos");
        System.out.printf("| %-20s |\n","5.-Regresar");
        System.out.println("------------------------");
        System.out.printf(">> ");
    }
    //Menu de users
    public static void menuMostrarOpcionesUsers(){
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","Biblioteca");
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","1.-Ver Libros");
        System.out.printf("| %-15s |\n","2.-Ver Transacciones");
        System.out.printf("| %-15s |\n","3.-Salir");
        System.out.println("-------------------");
        System.out.printf(">> ");
    }
    public static void menuMostrarOpcionesUsersTransaccions(){
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","Transacciones");
        System.out.println("-------------------");
        System.out.printf("| %-15s |\n","1.-Todas");
        System.out.printf("| %-15s |\n","2.-Por Fecha");
        System.out.printf("| %-15s |\n","3.-Salir");
        System.out.println("-------------------");
        System.out.printf(">> ");
    }
}
