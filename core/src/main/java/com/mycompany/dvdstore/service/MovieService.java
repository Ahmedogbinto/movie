package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;


public class MovieService implements MovieServiceInterface {
    private MovieRepository movieRepository = new MovieRepository();
    private MovieRepositoryInterface movieRepositoryInterface;
    public void registerMovie(Movie movie){
        movieRepositoryInterface.add(movie);

        System.out.println("Son titre est "+movie.getTitle()+" et son genre est "+movie.getGenre());
    }


}
