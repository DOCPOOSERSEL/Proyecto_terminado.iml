package Proyector;
import java.util.*;
public class Author {
    private Profile profile = new Profile();
    public ArrayList<Book> authorBooks = new ArrayList<>();

    public void setProfileAuthorCompleto(String nom, String apellido, Date birthdate){
        profile.setProfile(nom,apellido,birthdate);
    }
    public void setProfileAuthorName(String name){
        profile.setName(name);
    }

    public void setProfileAuthorLastName(String name){
        profile.setApellido(name);
    }

    public void setProfileAuthoDate(Date birthday){
        profile.setFecha(birthday);
    }

    public String getProfileAuthorName(){
        return profile.getName();
    }

    public String getProfileAuthorLastName(){
        return profile.getApellido();
    }

    public Date getProfileAuthorBirthdate(){
        return profile.getFecha();
    }

}
