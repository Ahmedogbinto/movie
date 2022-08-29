package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;


import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MovieController movieController = new MovieController();
        MovieService movieService = new MovieService();
        movieController.setMovieServiceInterface(movieService);

        MovieRepository movieRepository = new MovieRepository();
        movieService.setMovieRepositoryInterface(movieRepository);
        movieController.addMovieUsingConsole();

    }
}
