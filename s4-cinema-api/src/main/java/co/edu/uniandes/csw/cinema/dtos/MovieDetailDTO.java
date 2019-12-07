/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cinema.dtos;

import co.edu.uniandes.csw.cinema.entities.MovieEntity;
import co.edu.uniandes.csw.cinema.entities.PersonEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public class MovieDetailDTO extends MovieDTO{
    
    private String sinopsis;
    
    private List<PersonDTO> casting;
    
    public MovieDetailDTO(MovieEntity entity) {
        super(entity);
        if(entity != null){            
            this.sinopsis = entity.getSinopsis();
            List<PersonDTO> newCasting = new ArrayList<>();
            for(PersonEntity personEntity: entity.getCasting()){
                PersonDTO person = new PersonDTO(personEntity);
                newCasting.add(person);
            }
            this.casting = newCasting;
        }
    }

    public MovieDetailDTO() {
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public List<PersonDTO> getCasting() {
        return casting;
    }

    public void setCasting(List<PersonDTO> casting) {
        this.casting = casting;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    public MovieEntity toEntity(){
        MovieEntity entity = super.toEntity();
        entity.setSinopsis(this.sinopsis);
        List<PersonEntity> newCasting  = new ArrayList<>();
        for(PersonDTO dto: this.casting){
            PersonEntity personEntity = dto.toEntity();
            newCasting.add(personEntity);
        }
        entity.setCasting(newCasting);
        return entity;
    }
}
