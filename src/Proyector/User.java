package Proyector;
import Auxiliares.Password;

import java.util.*;


public class User {
    private Profile profileUser = new Profile();
    private String password;
    public ArrayList<Book> borrowedBooks = new ArrayList<>();
    public ArrayList<Transaction> clientTransactions = new ArrayList<>();

    public void setProfileUser(String Name , String Lastname, Date Birthdate, String Password) {
        profileUser.setProfile(Name,Lastname,Birthdate);
        password = Auxiliares.Password.hashString(Password);
    }

    //omg un stealix hiiiiii
    public  String getUserName(){
        return profileUser.getName();
    }
    public  String getUserLastName(){
        return profileUser.getApellido();
    }
    public  Date getUserDateOfBirth(){
        return profileUser.getFecha();
    }
    public String getPassword() {
        return password;
    }

    //Mas Skibidi setters <3
    public void setUserName(String newName){
        profileUser.setName(newName);
    }
    public  void setUserLastName(String newApellido){
        profileUser.setApellido(newApellido);
    }
    public  void setUserDateOfBirth(Date Aguacate){
        profileUser.setFecha(Aguacate);
    }
    public void setPassword(String password) {
        this.password = Auxiliares.Password.hashString(password);
    }
}
