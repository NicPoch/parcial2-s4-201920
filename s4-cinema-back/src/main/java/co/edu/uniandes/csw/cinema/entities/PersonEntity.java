/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cinema.entities;

import javax.persistence.Entity;

/**
 *
 * @author ca.forero10
 */
@Entity
public class PersonEntity extends BaseEntity {
    
    private String name;
    
    private String rol;
    
    private String image;

    public PersonEntity() {  
    
    }    

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRol() {
        return rol;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
