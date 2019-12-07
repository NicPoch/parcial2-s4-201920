/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cinema.dtos;

import co.edu.uniandes.csw.cinema.entities.MovieEntity;

/**
 *
 * @author ca.forero10
 */
public class MovieDTO {
    
    private Long id;
    
    private String name;
    
    private String gender;
    
    private Integer minutes;
    
    private String category;
    
    private String image;
    
    private Boolean active;

    public MovieDTO() {
    }
    
    public MovieDTO(MovieEntity entity) {
        if(entity != null){
            this.id = entity.getId();
            this.name = entity.getName();
            this.gender = entity.getGender();
            this.minutes = entity.getMinutes();
            this.category = entity.getCategory();
            this.image = entity.getImage();
            this.active = entity.getActive();
        }
    }

    public Boolean getActive() {
        return active;
    }

    public String getCategory() {
        return category;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public MovieEntity toEntity(){
        MovieEntity entity = new MovieEntity();
        entity.setActive(this.active);
        entity.setCategory(this.category);
        entity.setGender(this.gender);
        entity.setImage(this.image);
        entity.setId(this.id);
        entity.setMinutes(this.minutes);
        entity.setName(this.name);
        return entity;
    }
    
}
