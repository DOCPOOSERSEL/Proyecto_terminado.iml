package Controllers;
import Auxiliares.*;
import Proyector.Client;
import Repositories.AuthorRepository;
import Repositories.ClientRepository;

import java.util.*;
public class ClientController {
    static Scanner sc = new Scanner(System.in);
    static int pildora,auxn,indice;
    static String auxs;

    public static void metodoClientController(){
        do {
            do {
                MenuHolder.menuInicioClient();
                pildora = sc.nextInt();
                sc.nextLine();
                if ( pildora > 4 || pildora <= 0){
                    System.out.println("Nah uh");
                }
            }while(pildora > 3 || pildora <= 0);

            switch (pildora){
                case 1: /*Aqui te mete a las transacciones*/
                    TransactionController.transactionFuncion();
                case 2: /*Aqui va todo lo de los clientes*/
                    do {
                        MenuHolder.menuCreacionEdicionClient();
                        indice = sc.nextInt();
                        sc.nextLine();
                    }while(indice > 4 || indice <=0);
                    switch (indice) {//Crear o editar
                        case 1:/*Crear un cliente*/
                            Date newdate = new Date();
                            System.out.println("> > Ingrese los datos de el nuevo Cliente < <");
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
                            Client newClient = new Client();
                            newClient.setProfileClient(Name,LastName,newdate);
                            ClientRepository.clientArrayList.add(newClient);
                            break;
                        case 2:/*Editar un cliente*/
                            int confirmacion;
                            do {
                                do {
                                    MenuHolder.menuDeConfirmacionEdicionClient();
                                    confirmacion= sc.nextInt();
                                    sc.nextLine();
                                }while (confirmacion>2 || confirmacion<=0);
                                do {
                                    if (ClientRepository.clientArrayList.isEmpty()){
                                        System.out.println("No hay clientes para editar");
                                    }else{
                                        int indice2;
                                        do {
                                            MenuHolder.menuParaSeleccionarUnClienteParaEditar();
                                            System.out.printf(">> Ingrese el cliente: ");
                                            indice2 = sc.nextInt();
                                            sc.nextLine();
                                            indice2--;
                                        }while( indice2>ClientRepository.clientArrayList.size() || indice2<0 );

                                        do {
                                            MenuHolder.menuSeleccionarTipoDeEdicionCliente();
                                            auxn = sc.nextInt();
                                            sc.nextLine();
                                        }while(auxn>5 || auxn<=0);
                                        switch (auxn){
                                            case 1:
                                                System.out.printf(">> Ingrese el nuevo nombre: ");
                                                auxs = sc.nextLine();
                                                ClientRepository.clientArrayList.get(indice2).setCLientName(auxs);
                                                break;
                                            case 2:
                                                System.out.printf(">> Ingrese el nuevo Apellido: ");
                                                auxs = sc.nextLine();
                                                ClientRepository.clientArrayList.get(indice2).setCLientLastName(auxs);
                                                break;
                                            case 3:
                                                Date auxDate= new Date();
                                                System.out.println(">> Fecha << ");
                                                System.out.print(">Ingresa el dia: ");
                                                auxDate.setDate(auxn);
                                                System.out.print(">Ingresa el Mes: ");
                                                auxDate.setMonth(auxn);
                                                System.out.print(">Ingresa el Año: ");
                                                auxDate.setYear(auxn);
                                                ClientRepository.clientArrayList.get(indice2).setCLientDateOfBirth(auxDate);
                                                break;
                                            case 4:
                                                if (ClientRepository.clientArrayList.get(indice2).borrowedBooks.isEmpty()){
                                                    ClientRepository.clientArrayList.remove(indice2);
                                                    System.out.println("Cliente borrado con exito");
                                                }else{
                                                    System.out.println("No puede ser borrado ya que todavia tiene libros");
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Regresando al menu de confirmacion");
                                                break;
                                        }
                                    }
                                }while(auxn!=5);
                            }while (confirmacion!=2);
                            break;
                        case 3:/*Aqui regresa al de clientes y transacciones*/
                            System.out.println("Regressando al menu anterior");
                            break;
                    }
                    break;
                case 3:/*Aqui te regresa*/
                    MenuHolder.menuEnseñarclientesConLibros();
                    break;
                case 4:/*Aqui te regresa*/
                    System.out.println("Regresando al menu anterior");
                    break;
            }
        }while(pildora != 4);
    }
}
