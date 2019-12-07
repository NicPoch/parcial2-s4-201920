/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

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
package co.edu.uniandes.csw.cinema.resources;

import co.edu.uniandes.csw.cinema.dtos.MovieDTO;
import co.edu.uniandes.csw.cinema.dtos.MovieDetailDTO;
import co.edu.uniandes.csw.cinema.ejb.MovieLogic;
import co.edu.uniandes.csw.cinema.entities.MovieEntity;
import co.edu.uniandes.csw.cinema.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ca.forero10
 */
@Path("movies")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MovieResource {
    
    private static final Logger LOGGER = Logger.getLogger(MovieResource.class.getName());
    
    @Inject
    private MovieLogic movieLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    
    @POST
    public MovieDTO createBook(MovieDTO movie) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "MovieResource createMovie: input: {0}", movie);
        MovieDTO nuevoMovie = new MovieDTO(movieLogic.createMovie(movie.toEntity()));
        LOGGER.log(Level.INFO, "MovieResource createMovie: output: {0}", nuevoMovie);
        return nuevoMovie;
    }
    
    @GET
    public List<MovieDTO> getMovies() {
        LOGGER.info("MovieResource getMovies: input: void");
        List<MovieDTO> listaMovies = listEntity2DetailDTO(movieLogic.getMovies());
        LOGGER.log(Level.INFO, "MovieResource getMovies: output: {0}", listaMovies);
        return listaMovies;
    }
    
   
    @GET
    @Path("{movieId: \\d+}")
    public MovieDetailDTO getMovie(@PathParam("movieId") Long movieId) {
        LOGGER.log(Level.INFO, "MovieResource getMovie: input: {0}", movieId);
        MovieEntity entity = movieLogic.getMovie(movieId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /movies/" + movieId + " no existe.", 404);
        }
        MovieDetailDTO movieDetailDTO = new MovieDetailDTO(entity);
        LOGGER.log(Level.INFO, "MovieResource getMovie: output: {0}", movieDetailDTO);
        return movieDetailDTO;
    }
    
     private List<MovieDTO> listEntity2DetailDTO(List<MovieEntity> entityList) {
        List<MovieDTO> list = new ArrayList<>();
        for (MovieEntity entity : entityList) {
            list.add(new MovieDTO(entity));
        }
        return list;
    }
}
