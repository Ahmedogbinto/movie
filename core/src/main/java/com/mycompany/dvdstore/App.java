package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.repository.MemoryMovieRepository;
import com.mycompany.dvdstore.service.DefaultMovieService;
import com.mycompany.dvdstore.service.LiveMovieService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MovieController movieController = new MovieController();


        DefaultMovieService defaultMovieService = new DefaultMovieService();
        movieController.setMovieServiceInterface(defaultMovieService);

        MemoryMovieRepository memoryMovieRepository = new MemoryMovieRepository();
        defaultMovieService.setMovieRepositoryInterface(memoryMovieRepository);


        LiveMovieService liveMovieService = new LiveMovieService();
        movieController.setMovieServiceInterface(liveMovieService);

        FileMovieRepository fileMovieRepository = new FileMovieRepository();
        liveMovieService.setMovieRepositoryInterface(fileMovieRepository);

        movieController.addMovieUsing();
    }
}
