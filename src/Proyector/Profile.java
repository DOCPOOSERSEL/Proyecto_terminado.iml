package Proyector;
import java.util.Date;
public class Profile  {
    private String profileName;
    private String profileLastName;
    private Date profileDate = new Date();

    public void setProfile(String skibiname, String skibidiapellido, Date skibidifecha) {
        this.profileName = skibiname;
        this.profileLastName = skibidiapellido;
        profileDate = skibidifecha;
    }

    // Skibidi getters
    public String getName() {
        return profileName;
    }
    public String getApellido() {
        return profileLastName;
    }
    public Date getFecha() {
        return profileDate;
    }


    //skibidisetters
    public void setName(String skibiname) {
        this.profileName = skibiname;
    }
    public void setApellido(String skibidiapellido) {
        this.profileLastName = skibidiapellido;
    }
    public void setFecha(Date skibidifecha) {
        profileDate = skibidifecha;
    }
}
