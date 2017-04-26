/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.svim.model;

/**
 *
 * @author Cauê Ghetti
 */
public class Cargo {
    
    private int idCargo;
    private String cargo;
    private int hierarquia;

    public Cargo() {
    }

    public Cargo(int idCargo, String cargo, int hierarquia) {
        this.idCargo = idCargo;
        this.cargo = cargo;
        this.hierarquia = hierarquia;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(int hierarquia) {
        this.hierarquia = hierarquia;
    }
    
    
    
}
