package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private static List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);

        System.out.println("Le DVD a bien été ajouté avec succèes a la liste des films");
    }
}
