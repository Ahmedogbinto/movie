package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;

public class GoLiveMovieService implements MovieServiceInterface{

    private GoLiveMovieRepository movieLiveRepository = new GoLiveMovieRepository();

    public void registerMovie(Movie movie){

        movieLiveRepository.add(movie);

        System.out.println(" Le Film a bien été ajouté dans fichier txt");

    }

}
