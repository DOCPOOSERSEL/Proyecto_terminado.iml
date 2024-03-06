package Proyector;
import java.util.*;


public class Client {
    private Profile profileClient = new Profile();
    public ArrayList<Book> borrowedBooks = new ArrayList<>();
    public ArrayList<Transaction> clientTransactions = new ArrayList<>();

    public void setProfileClient (String Name ,String Lastname, Date Birthdate) {
        profileClient.setProfile(Name,Lastname,Birthdate);
    }

    //omg un stealix hiiiiii
    public  String getCLientName(){
        return profileClient.getName();
    }
    public  String getCLientLastName(){
        return profileClient.getApellido();
    }
    public  Date getCLientDateOfBirth(){
        return profileClient.getFecha();
    }

    //Mas Skibidi setters <3
    public void setCLientName(String newName){
        profileClient.setName(newName);
    }
    public  void setCLientLastName(String newApellido){
        profileClient.setApellido(newApellido);
    }
    public  void setCLientDateOfBirth(Date Aguacate){
        profileClient.setFecha(Aguacate);
    }

}
