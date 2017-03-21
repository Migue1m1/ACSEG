/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.reconocimiento.models;

public class Persona 
{
    private int CI;
    private String nombre;
    private int edad;
    private String carrera;
    private String sede;
    private boolean enCampus;
    private String mtrAuto;
    
    public Persona()
    {
        this.CI = 0;
        this.nombre = "";
        this.edad = 0;
        this.carrera = "";
        this.sede = "";
        this.enCampus = false;
        this.mtrAuto = "";
    }
    
    public int getCI()
    {
        return this.CI;
    }
    
    public void setCI(int CI)
    {
        this.CI = CI;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public int getEdad()
    {
        return this.edad;
    }
    
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    
    public String getCarrera()
    {
        return this.carrera;
    }
    
    public void setCarrera(String carrera)
    {
        this.carrera = carrera;
    }
    
    public String getSede()
    {
        return this.sede;
    }
    
    public void setSede(String sede)
    {
        this.sede = sede;
    }
    
    public Boolean getEnCampus()
    {
        return this.enCampus;
    }
    
    public void setEnCampus(boolean enCampus)
    {
        this.enCampus = enCampus;
    }
    
    public String getMatricula()
    {
        return this.mtrAuto;
    }
    
    public void setMatricula(String mtr)
    {
        this.mtrAuto = mtr;
    }
    
    @Override
    public String toString()
    {
        if (this.CI != 0)
            return "CI: " + this.CI + ", nombre: " + this.nombre
                + ", edad: " + this.edad + ", carrera: " + this.carrera
                + ", enCampus: " + this.enCampus
                + ", sede: "+ this.sede + ", matricula: " + this.mtrAuto;
        else
            return "";
    }
}
