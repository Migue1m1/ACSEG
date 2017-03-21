/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acseg.reconocimiento.models;

/**
 *
 * @author joandv
 */
public class Usuario {
    
    private String user;
    private String pass;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Usuario() {
        this.user="";
        this.pass="";
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Usuarior=" + user + ", Contraseña=" + pass + '}';
    }
    
    
    
}
