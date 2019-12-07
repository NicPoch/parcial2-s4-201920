/*
MIT License

Copyright (c) 2019 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.cinema.ejb;


import co.edu.uniandes.csw.cinema.entities.MovieEntity;
import co.edu.uniandes.csw.cinema.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.cinema.persistence.MoviePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MovieLogic {

    private static final Logger LOGGER = Logger.getLogger(MovieLogic.class.getName());

    @Inject
    private MoviePersistence persistence;
    
    public MovieEntity createMovie(MovieEntity movieEntity)throws BusinessLogicException
    {
        //TODO
        persistence.create(movieEntity);
        return movieEntity;
    }

     public List<MovieEntity> getMovies() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas los películas");
        List<MovieEntity> movies = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas los películas");
        return movies;
    }
     
     public MovieEntity getMovie(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una película con id = {0}", id);
        MovieEntity movieEntity = persistence.find(id);
        if (movieEntity == null) {
            LOGGER.log(Level.SEVERE, "La película con el id = {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la película con id = {0}", id);
        return movieEntity;
     }
    
}
