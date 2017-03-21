/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package acseg.reconocimiento.models;

public class Vehiculo 
{
    private boolean enCampus;
    private String mtrAuto;
    
    
    public Vehiculo()
    {

        this.enCampus = false;
        this.mtrAuto = "";
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
    
  
}
