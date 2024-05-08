package Controllers;

import Auxiliares.ConsoleReader;
import Auxiliares.MenuHolder;
import Auxiliares.Permissions;
import Proyector.Admins;
import Repositories.UserRepository;
import java.util.*;

public class AdminController {
    static Scanner sc = new Scanner(System.in);
    static int indice, auxn;
    static String auxs, auxs2;
    static HashMap<Integer, Runnable> actions = new HashMap<>();

    public static void adminsCRUD(){
        actions.put(1, AdminController::crearUnAdmin);
        actions.put(2, AdminController::adminEditor);
        actions.put(3, () ->{
            boolean checkTrue = true;
            do {
                MenuHolder.menuDeSeleccionDeAdmin();
                auxn = sc.nextInt();
                auxn--;
            }while(auxn>UserRepository.adminsArrayList.size() || auxn<0);
            if(UserRepository.adminsArrayList.get(auxn).getSuperAdmin() == checkTrue){
                System.out.println("No se puede borrar a la autoridad suprema");
            }else{
                UserRepository.generalArraylist.remove(UserRepository.adminsArrayList.get(auxn));
                UserRepository.adminsArrayList.remove(auxn);
                System.out.println("Administrador borrado con exito");
            }
        });
        actions.put(4, () ->{
            System.out.println("Regresando al menu anterior");
        });
        do {
            do {
                MenuHolder.menuDeCreacionDeAdmins();
                indice = sc.nextInt();
                sc.nextLine();
            }while(indice >4 || indice <=0);
            actions.get(indice).run();
        }while(indice != 4);
    }

    public static void setAdminPermisions(Admins newAdmin){
        do {
            System.out.println("Tiene permiso de Crear/Editar (S) (N)");
            System.out.print(">> ");
            auxs2 = sc.nextLine();
        }while(!auxs2.equals("s") && !auxs2.equals("S") && !auxs2.equals("n") && !auxs2.equals("N"));
        if (auxs2.equals("s") || auxs2.equals("S") && !newAdmin.adminPermissions.contains(Permissions.WRITE)){
            newAdmin.adminPermissions.add(Permissions.WRITE);
        }else if (newAdmin.adminPermissions.contains(Permissions.WRITE)){
            newAdmin.adminPermissions.remove(Permissions.WRITE);
        }
        do {
            System.out.println("Tiene permiso de Eliminar (S) (N)");
            System.out.print(">>");
            auxs2 = sc.nextLine();
        }while(!auxs2.equals("s") && !auxs2.equals("S") && auxs2 != "n" && auxs2 != "N");
        if (auxs2.equals("s") || auxs2.equals("S") && !newAdmin.adminPermissions.contains(Permissions.DELETE)){
            newAdmin.adminPermissions.add(Permissions.DELETE);
        }else if (newAdmin.adminPermissions.contains(Permissions.DELETE)){
            newAdmin.adminPermissions.remove(Permissions.DELETE);
        }
        do {
            System.out.println("Tiene permiso de Leer (S) (N)");
            System.out.print(">>");
            auxs2 = sc.nextLine();
        }while(!auxs2.equals("s") && !auxs2.equals("S") && !auxs2.equals("n") && !auxs2.equals("N"));
        if (auxs2.equals("s") || auxs2.equals("S") && !newAdmin.adminPermissions.contains(Permissions.READ)){
            newAdmin.adminPermissions.add(Permissions.READ);
        }else if(newAdmin.adminPermissions.contains(Permissions.READ)){
            newAdmin.adminPermissions.remove(Permissions.READ);
        }
    }
    public static void adminEditor(){
        int opcion,userNum,tipoDeEdicion;
        do {
            do {
                MenuHolder.menuDeConfirmacionEdicionClient();
                opcion = sc.nextInt();
                sc.nextLine();
            }while(opcion<1 || opcion>2);
            if (opcion ==1){
                do {
                    MenuHolder.menuDeSeleccionDeAdmin();
                    userNum = sc.nextInt();
                    userNum--;
                }while(userNum>UserRepository.adminsArrayList.size() || userNum<0);
                do {
                    MenuHolder.menuDeEdicionAdmin();
                    tipoDeEdicion = sc.nextInt();
                    sc.nextLine();
                }while(tipoDeEdicion>5 || tipoDeEdicion<=0);
                switch (tipoDeEdicion){
                    case 1:
                        System.out.printf(">> Ingrese el nuevo nombre: ");
                        auxs = sc.nextLine();
                        UserRepository.adminsArrayList.get(userNum).setUserName(auxs);
                        break;
                    case 2:
                        System.out.printf(">> Ingrese el nuevo Apellido: ");
                        auxs = sc.nextLine();
                        UserRepository.adminsArrayList.get(userNum).setUserLastName(auxs);
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
                        UserRepository.adminsArrayList.get(userNum).setUserDateOfBirth(auxDate);
                        break;
                    case 4:
                        setAdminPermisions(UserRepository.adminsArrayList.get(userNum));
                    case 5:
                        System.out.println("Regresando sin editar");
                        break;
                }
            }
        }while(opcion != 2 );
    }
    public static void crearUnAdmin(){
        Date newdate = new Date();
        System.out.println("> > Ingrese los datos de el nuevo Admin < <");
        String Name = ConsoleReader.readString("Ingrese el nombre: ");
        String LastName = ConsoleReader.readString("Ingrese el Apellido: ");
        System.out.println("> > Ingrese la fecha de nacimiento < <");
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Dia: ");
        newdate.setDate(auxn);
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Mes: ");
        newdate.setMonth(auxn);
        auxn = ConsoleReader.validatePositiveInt("Ingrese el Año: ");
        newdate.setYear(auxn);
        auxs = ConsoleReader.readString("Ingrese la contraseña: ");
        Admins newAdmin = new Admins();
        newAdmin.setProfileUser(Name,LastName,newdate,auxs);
        setAdminPermisions(newAdmin);
        UserRepository.generalArraylist.add(newAdmin);
        UserRepository.adminsArrayList.add(newAdmin);
    }
}
