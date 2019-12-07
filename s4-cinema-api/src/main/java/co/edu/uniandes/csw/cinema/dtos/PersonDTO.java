/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cinema.dtos;

import co.edu.uniandes.csw.cinema.entities.PersonEntity;

/**
 *
 * @author ca.forero10
 */
public class PersonDTO {
    
    private Long id;
    
    private String name;
    
    private String rol;
    
    private String image;

    public PersonDTO() {
    }
    
    public PersonDTO(PersonEntity entity){
        if(entity != null){
            this.id = entity.getId();
            this.name = entity.getName();
            this.rol = entity.getRol();
            this.image = entity.getImage();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public PersonEntity toEntity(){
        PersonEntity entity = new PersonEntity();
        entity.setId(this.id);
        entity.setImage(this.image);
        entity.setName(this.name);
        entity.setRol(this.rol);
        return entity;
    }
    
}
