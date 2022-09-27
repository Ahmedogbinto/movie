package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> movies = new ArrayList<>();
    private static long lastId = 0L;


    public void add(Movie movie){

        movie.setId(lastId++);
        movies.add(movie);

        System.out.println("Memory: Le film" +movie.getTitle()+" a été ajouté");
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(long id) {
        return movies.stream().
                filter(m ->m.getId()==id).
                findFirst().get();
    }
}
