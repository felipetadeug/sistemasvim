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
public class Login {
    
    private String user;
    private String password;
    
    Login(String user, String password){
    
        this.user = user;
        this.password = password;
        
    }
    
    Login(){
    
    }
    
    public String getUser(){
        return user;
    }
    
    public void setUser(String User){
        this.user = User;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String Password){
        this.password = Password;
    }
    
}
