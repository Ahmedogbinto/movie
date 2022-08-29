package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;
import com.mycompany.dvdstore.service.GoLiveMovieService;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;

import java.util.Scanner;

public class MovieController {

    private MovieService movieService = new MovieService();
    private GoLiveMovieService liveMovieService = new GoLiveMovieService();

    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    public void addMovieUsingConsole(){
        System.out.println( "Quel est le titre du film a ajouté?" );
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Movie movie = new Movie();
        movie.setTitle(title);
        System.out.println( "Quel est le genre du film ?" );
        String genre= scanner.nextLine();
        movie.setGenre(genre);

        movieServiceInterface.registerMovie(movie);


    }
}

