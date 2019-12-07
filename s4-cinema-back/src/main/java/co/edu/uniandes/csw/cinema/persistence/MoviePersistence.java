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
package co.edu.uniandes.csw.cinema.persistence;

import co.edu.uniandes.csw.cinema.entities.MovieEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MoviePersistence {

    private static final Logger LOGGER = Logger.getLogger(MoviePersistence.class.getName());

    @PersistenceContext(unitName = "cinemaPU")
    protected EntityManager em;
    
    public MovieEntity create (MovieEntity movie)
    {
        em.persist(movie);
        return movie;
    }
        
    public List<MovieEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todass los películas");
        Query q = em.createQuery("select u from MovieEntity u");
        return q.getResultList();
    }
    
    public MovieEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando la película con id={0}", id);
        return em.find(MovieEntity.class, id);
    }
}
