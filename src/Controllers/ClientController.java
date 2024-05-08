package Controllers;
import Auxiliares.*;
import Proyector.Admins;
import Proyector.User;
import Repositories.UserRepository;

import java.util.*;
public class ClientController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn,indice;
    static String auxs,password;
    static boolean checkTrue=true;
    static HashMap<Integer, Runnable> actions = new HashMap<>();
    public static void metodoClientController(Admins loggedInAccount){
        actions.put(1, () ->{
            TransactionController.transactionFuncion(loggedInAccount);
        });
        actions.put(2, () ->{
            do {
                do {
                    MenuHolder.menuCreacionEdicionClient();
                    indice = sc.nextInt();
                    sc.nextLine();
                }while(indice > 3 || indice <= 0);
                switch (indice) {//Crear o editar
                    case 1:/*Crear un Usuario*/
                        if(loggedInAccount.adminPermissions.contains(Permissions.WRITE) || loggedInAccount.getSuperAdmin()==checkTrue){
                            clientCreator();
                        }else{
                            System.out.println("Sin Autorizacion");
                        }
                        break;
                    case 2:/*Editar un cliente*/
                        if(loggedInAccount.adminPermissions.contains(Permissions.WRITE) || loggedInAccount.getSuperAdmin() == checkTrue){
                            clientEditor(loggedInAccount);
                        }else{
                            System.out.println("Sin Autorizacion");
                        }
                        break;
                    case 3:/*Aqui regresa al de clientes y transacciones*/
                        System.out.println("Regressando al menu anterior");
                        break;
                }
            }while(indice != 3);
        });
        actions.put(3, () ->{
            if (loggedInAccount.adminPermissions.contains(Permissions.READ)|| loggedInAccount.getSuperAdmin()==checkTrue){
                MenuHolder.menuEnseñarClientesConLibros();
            }else{
                System.out.println("Sin Autorizacion");
            }
        });
        actions.put(4, () ->{
            System.out.println("Regresando al menu anterior");
        });
        do {
            do {
                MenuHolder.menuInicioClient();
                pildora = sc.nextInt();
                sc.nextLine();
                if ( pildora > 4 || pildora <= 0){
                    System.out.println("Nah uh");
                }
            }while(pildora > 4 || pildora <= 0);
            actions.get(pildora).run();
        }while(pildora != 4);
    }
    public static void clientCreator(){
        Date newdate = new Date();
        System.out.println("> > Ingrese los datos de el nuevo Cliente < <");
        String Name = ConsoleReader.readString("Ingrese el nombre: ");
        String LastName = ConsoleReader.readString("Ingrese el Apellido: ");
        System.out.println("> > Ingrese la fecha de nacimiento < <");
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Dia: ");
        newdate.setDate(auxn);
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Mes: ");
        newdate.setMonth(auxn);
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Año: ");
        newdate.setYear(auxn);
        password = ConsoleReader.readString("Ingrese la contraseña: ");
        User newClient = new User();
        newClient.setProfileUser(Name,LastName,newdate,password);
        UserRepository.userArrayList.add(newClient);
        UserRepository.generalArraylist.add(newClient);
    }
    public static void clientEditor(Admins loggedInAccount){
        int confirmacion;
        do {
            do {
                MenuHolder.menuDeConfirmacionEdicionClient();
                confirmacion= sc.nextInt();
                sc.nextLine();
            }while (confirmacion>2 || confirmacion<=0);
            if (confirmacion == 1){
                do {
                    if (UserRepository.userArrayList.isEmpty()){
                        System.out.println("No hay clientes para editar");
                    }else{
                        int indice2;
                        do {
                            MenuHolder.menuParaSeleccionarUnClienteParaEditar();
                            System.out.printf(">> Ingrese el cliente: ");
                            indice2 = sc.nextInt();
                            sc.nextLine();
                            indice2--;
                        }while( indice2> UserRepository.userArrayList.size() || indice2<0 );
                        do {
                            MenuHolder.menuSeleccionarTipoDeEdicionCliente();
                            auxn = sc.nextInt();
                            sc.nextLine();
                        }while(auxn>5 || auxn<=0);
                        switch (auxn){
                            case 1:
                                System.out.printf(">> Ingrese el nuevo nombre: ");
                                auxs = sc.nextLine();
                                UserRepository.userArrayList.get(indice2).setUserName(auxs);
                                break;
                            case 2:
                                System.out.printf(">> Ingrese el nuevo Apellido: ");
                                auxs = sc.nextLine();
                                UserRepository.userArrayList.get(indice2).setUserLastName(auxs);
                                break;
                            case 3:
                                Date auxDate= new Date();
                                System.out.println(">> Fecha << ");
                                System.out.print(">Ingresa el dia: ");
                                auxn = sc.nextInt();
                                auxDate.setDate(auxn);
                                System.out.print(">Ingresa el Mes: ");
                                auxn = sc.nextInt();
                                auxDate.setMonth(auxn);
                                System.out.print(">Ingresa el Año: ");
                                auxn = sc.nextInt();
                                auxDate.setYear(auxn);
                                sc.nextLine();
                                UserRepository.userArrayList.get(indice2).setUserDateOfBirth(auxDate);
                                break;
                            case 4:
                                if (loggedInAccount.adminPermissions.contains(Permissions.DELETE)|| loggedInAccount.getSuperAdmin()==checkTrue){
                                    if (UserRepository.userArrayList.get(indice2).borrowedBooks.isEmpty()){
                                        UserRepository.generalArraylist.remove(UserRepository.userArrayList.get(indice2));
                                        UserRepository.userArrayList.remove(indice2);
                                        System.out.println("Cliente borrado con exito");
                                    }else{
                                        System.out.println("No puede ser borrado ya que todavia tiene libros");
                                    }
                                }else {
                                    System.out.println("Sin Autorizacion");
                                }
                                break;
                            case 5:
                                System.out.println("Regresando al menu de confirmacion");
                                break;
                        }
                    }
                }while(auxn!=5);
            }
        }while (confirmacion!=2);
    }
}
