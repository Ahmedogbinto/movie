package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LiveMovieService implements MovieServiceInterface {
    @Autowired
    private MovieRepositoryInterface movieRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie registerMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie>getMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> optionalMovie=movieRepository.findById(id);
        if(optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie = optionalMovie.get();

        //deproxification et initialisation des proxy
        movie.getMainActor().getFirstName();
        movie.getReviews().forEach(review ->{
            review.getMark();
            review.setMovie(null);   // Nous forçons le film à null pour eviter que Jackson ne tombe dans une boucle infinie
        });

        return movie;
    }
}
