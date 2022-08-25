package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import org.w3c.dom.ls.LSOutput;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public void registerMovie(Movie movie){
        movieRepository.addMovie(movie);

        System.out.println("Son titre est "+movie.getTitle()+" et son genre est "+movie.getGenre());
    }

}
