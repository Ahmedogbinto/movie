package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> movies = new ArrayList<>();

    public void add(Movie movie){
        movies.add(movie);

        System.out.println("Memoire interne: Le DVD a bien été ajouté avec succèes a la liste des films");
    }
}
