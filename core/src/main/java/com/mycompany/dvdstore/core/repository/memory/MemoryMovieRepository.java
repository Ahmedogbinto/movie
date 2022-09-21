package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> movies = new ArrayList<>();

    public void add(Movie movie){
        movies.add(movie);

        System.out.println("Memoire interne: Le DVD a bien été ajouté avec succèes a la liste des films");
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

}
