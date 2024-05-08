package Proyector;

import java.util.Date;

public abstract class Client {
    abstract public void setProfileUser(String Name , String Lastname, Date Birthdate, String Password);

    //omg un stealix hiiiiii
    abstract public  String getUserName();

    abstract public  String getUserLastName();

    abstract public  Date getUserDateOfBirth();

    abstract public String getPassword();

    //Mas Skibidi setters <3
    abstract public void setUserName(String newName);

    abstract public  void setUserLastName(String newApellido);

    abstract public  void setUserDateOfBirth(Date Aguacate);

    abstract public void setPassword(String password);
}
