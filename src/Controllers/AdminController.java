package Controllers;

import Auxiliares.MenuHolder;
import Auxiliares.Permissions;
import Proyector.Admins;
import Repositories.UserRepository;

import java.util.Date;
import java.util.Scanner;

public class AdminController {
    static Scanner sc = new Scanner(System.in);
    static int indice, auxn;
    static String auxs, auxs2;
    public static void adminsCRUD(){
        do {
            do {
                MenuHolder.menuDeCreacionDeAdmins();
                indice = sc.nextInt();
                sc.nextLine();
                indice--;
            }while(indice >4 || indice <=0);
            switch (indice){//Editor de admins
                case 1:/*Crear un admin*/
                    Date newdate = new Date();
                    System.out.println("> > Ingrese los datos de el nuevo Admin < <");
                    System.out.printf("Ingrese el nombre: ");
                    String Name = sc.nextLine();
                    System.out.printf("Ingrese el Apellido: ");
                    String LastName = sc.nextLine();
                    System.out.println("> > Ingrese la fecha de nacimiento < <");
                    System.out.printf("Ingrese el Dia: ");
                    auxn = sc.nextInt();
                    newdate.setDate(auxn);
                    System.out.printf("Ingrese el Mes: ");
                    auxn = sc.nextInt();
                    newdate.setMonth(auxn);
                    System.out.printf("Ingrese el Año: ");
                    auxn = sc.nextInt();
                    newdate.setYear(auxn);
                    sc.nextLine();
                    System.out.println(("Ingrese la contraseña"));
                    System.out.print(">> ");
                    auxs = sc.nextLine();
                    Admins newAdmin = new Admins();
                    newAdmin.setProfileUser(Name,LastName,newdate,auxs);
                    setAdminPermisions(newAdmin);
                    UserRepository.userArrayList.add(newAdmin);
                    break;
                case 2:/*Editar un administrador*/
                    adminEditor();
                    break;
                case 3:/*Eliminar un administrador*/
                    boolean checkTrue = true;
                    do {
                        MenuHolder.menuDeSeleccionDeAdmin();
                        auxn = sc.nextInt();
                        auxn--;
                    }while(auxn>UserRepository.adminsArrayList.size() || auxn<0);
                    if(UserRepository.adminsArrayList.get(auxn).getSuperAdmin() == checkTrue){
                        System.out.println("No se puede borrar a la autoridad suprema");
                    }else{
                        UserRepository.adminsArrayList.remove(auxn);
                        System.out.println("Administrador borrado con exito");
                    }
                case 4:/*Regresar*/
                    System.out.println("Regresando al menu Principal");
                    break;
            }
        }while(indice != 4);
    }

    public static void setAdminPermisions(Admins newAdmin){
        do {
            System.out.println("Tiene permiso de Crear/Editar (S) (N)");
            System.out.print(">> ");
            auxs2 = sc.nextLine();
        }while(auxs2 != "s" && auxs2 != "S" && auxs2 != "n" && auxs2 != "N");
        if (auxs2 == "s" || auxs2 == "S" && !newAdmin.adminPermissions.contains(Permissions.WRITE)){
            newAdmin.adminPermissions.add(Permissions.WRITE);
        }else if (auxs2 == "n" || auxs2 == "N" && newAdmin.adminPermissions.contains(Permissions.WRITE)){
            newAdmin.adminPermissions.remove(Permissions.WRITE);
        }
        do {
            System.out.println("Tiene permiso de Eliminar (S) (N)");
            System.out.print(">>");
            auxs2 = sc.nextLine();
        }while(auxs2 != "s" && auxs2 != "S" && auxs2 != "n" && auxs2 != "N");
        if (auxs2 == "s" || auxs2 == "S" && !newAdmin.adminPermissions.contains(Permissions.DELETE)){
            newAdmin.adminPermissions.add(Permissions.DELETE);
        }else if (auxs2 == "n" || auxs2 == "N" && newAdmin.adminPermissions.contains(Permissions.DELETE)){
            newAdmin.adminPermissions.remove(Permissions.DELETE);
        }
        do {
            System.out.println("Tiene permiso de Leer (S) (N)");
            System.out.print(">>");
            auxs2 = sc.nextLine();
        }while(auxs2 != "s" && auxs2 != "S" && auxs2 != "n" && auxs2 != "N");
        if (auxs2 == "s" || auxs2 == "S" && !newAdmin.adminPermissions.contains(Permissions.READ)){
            newAdmin.adminPermissions.add(Permissions.READ);
        }else if(auxs2 == "n" || auxs2 == "N" && newAdmin.adminPermissions.contains(Permissions.READ)){
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
}
