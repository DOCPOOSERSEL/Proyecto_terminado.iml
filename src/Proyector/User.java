package Proyector;
import Auxiliares.Password;

import java.util.*;


public class User extends Client {
    private Profile profileUser = new Profile();
    private String password;
    public ArrayList<Book> borrowedBooks = new ArrayList<>();
    public ArrayList<Transaction> clientTransactions = new ArrayList<>();

    @Override
    public void setProfileUser(String Name , String Lastname, Date Birthdate, String Password) {
        profileUser.setProfile(Name,Lastname,Birthdate);
        password = Auxiliares.Password.hashString(Password);
    }

    //omg un stealix hiiiiii
    @Override
    public  String getUserName(){
        return profileUser.getName();
    }
    @Override
    public  String getUserLastName(){
        return profileUser.getApellido();
    }
    @Override
    public  Date getUserDateOfBirth(){
        return profileUser.getFecha();
    }
    @Override
    public String getPassword() {
        return password;
    }

    //Mas Skibidi setters <3
    public void setUserName(String newName){
        profileUser.setName(newName);
    }
    @Override
    public  void setUserLastName(String newApellido){
        profileUser.setApellido(newApellido);
    }
    @Override
    public  void setUserDateOfBirth(Date Aguacate){
        profileUser.setFecha(Aguacate);
    }
    @Override
    public void setPassword(String password) {
        this.password = Auxiliares.Password.hashString(password);
    }
}
