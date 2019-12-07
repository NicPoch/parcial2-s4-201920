/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cinema.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author ca.forero10
 */
@Entity
public class MovieEntity extends BaseEntity {
    
    private String name;
    
    private String gender;
    
    private Integer minutes;
    
    private String category;
    
    private String sinopsis;
    
    private String image;
    
    private Boolean active;
    
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PersonEntity> casting;

    public MovieEntity() {
    }
    
    public String getCategory() {
        return category;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getActive() {
        return active;
    }

    public String getImage() {
        return image;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }

    public String getSinopsis() {
        return sinopsis;
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

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<PersonEntity> getCasting() {
        return casting;
    }

    public void setCasting(List<PersonEntity> casting) {
        this.casting = casting;
    }
    
    
   
}
