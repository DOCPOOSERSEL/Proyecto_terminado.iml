package Proyector;

import Auxiliares.Permissions;

import java.util.ArrayList;


public class Admins extends User{
    public ArrayList<Permissions> adminPermissions = new ArrayList<>();
    private boolean isSuperAdmin;
    
    public boolean getSuperAdmin() {
        return isSuperAdmin;
    }
    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

}
