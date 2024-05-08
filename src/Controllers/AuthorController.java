package Controllers;
import Auxiliares.MenuHolder;
import Auxiliares.Permissions;
import Proyector.*;
import Repositories.*;
import java.util.*;
public class AuthorController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn;
    static String auxs;
    static boolean checkTrue=true;
    static HashMap<Integer, Runnable> actions = new HashMap<>();
    public static void authorMetodo(Admins loggedInAccount ) {
        actions.put(1, () ->{
            if(loggedInAccount.adminPermissions.contains(Permissions.WRITE) || loggedInAccount.getSuperAdmin()==checkTrue){
                String nom1,nom2;
                int n3;
                Date birthDate = new Date();
                Author newAuthor = new Author();
                System.out.println("< < DATOS DEL AUTOR NUEVO > >");
                System.out.printf("Nombre: ");
                nom1 = sc.nextLine();
                System.out.printf("Apellido: ");
                nom2 = sc.nextLine();
                System.out.println("< < FECHA DE NACIMIENTO > >");
                System.out.printf("Dia: ");
                n3 = sc.nextInt();
                birthDate.setDate(n3);
                sc.nextLine();
                System.out.printf("Mes: ");
                n3 = sc.nextInt();
                birthDate.setMonth(n3);
                sc.nextLine();
                System.out.printf("Año: ");
                n3 = sc.nextInt();
                birthDate.setYear(n3);
                sc.nextLine();
                //Aqui llace mi mas nueva creacion
                newAuthor.setProfileAuthorCompleto(nom1,nom2,birthDate);
                AuthorRepository.authorArrayList.add(newAuthor);
            }else {
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(2, () ->{
            if(loggedInAccount.adminPermissions.contains(Permissions.WRITE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                int pildora2,indice;
                do {
                    MenuHolder.menuAuthorSinLibros();
                    System.out.printf(">> Ingrese el indice: ");
                    indice = sc.nextInt();
                    sc.nextLine();
                    indice--;
                }while (indice>AuthorRepository.authorArrayList.size() || indice < 0);
                do {
                    MenuHolder.menuAuthorEdicion();
                    pildora2 = sc.nextInt();
                    if (pildora2 != 1 && pildora2 != 2 && pildora2 !=3 && pildora2 !=4 ){
                        System.out.println("Nah uh");
                    }
                }while ( pildora2 != 1 && pildora2 != 2 && pildora2 !=3 && pildora2 !=4 );
                switch (pildora2){
                    case 1:
                        System.out.printf(">> Ingrese el nuevo nombre: ");
                        auxs = sc.nextLine();
                        AuthorRepository.authorArrayList.get(indice).setProfileAuthorName(auxs);
                        break;
                    case 2:
                        System.out.printf(">> Ingrese el nuevo apellido: ");
                        auxs = sc.nextLine();
                        AuthorRepository.authorArrayList.get(indice).setProfileAuthorLastName(auxs);
                        break;
                    case 3:
                        Date Ndate = new Date();
                        System.out.println(">> Fecha << ");
                        System.out.print(">Ingresa el dia: ");
                        Ndate.setDate(auxn);
                        System.out.print(">Ingresa el Mes: ");
                        Ndate.setMonth(auxn);
                        System.out.print(">Ingresa el Año: ");
                        Ndate.setYear(auxn);
                        AuthorRepository.authorArrayList.get(indice).setProfileAuthoDate(Ndate);
                        break;
                }
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(3, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.DELETE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                int indice;
                MenuHolder.menuAuthorSinLibros();
                do {
                    System.out.printf(">> Ingrese el indice: ");
                    indice = sc.nextInt();
                    indice--;
                }while (indice>AuthorRepository.authorArrayList.size() || indice < 0);
                sc.nextLine();

                if ( AuthorRepository.authorArrayList.get(indice).authorBooks.isEmpty()){
                    AuthorRepository.authorArrayList.remove(indice);
                    System.out.println("Autor borrado con exito");
                }else{
                    System.out.println("Autor no puede ser borrado ya que todavia hay libros");
                }
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(4, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.READ)|| loggedInAccount.getSuperAdmin()==checkTrue){
                MenuHolder.menuAuthorConLibros();
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(5, () ->{
            System.out.println("Regresando al menu anterior");
        });
        do {
            do {
                MenuHolder.menuAuthorOpcionesPrincipales();
                pildora = sc.nextInt();
                sc.nextLine();
                if (pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5){
                    System.out.println("Nah uh");
                }
            }while ( pildora != 1 && pildora != 2 && pildora !=3 && pildora !=4 && pildora !=5);
            actions.get(pildora).run();
        }while (pildora != 5);
    }
}