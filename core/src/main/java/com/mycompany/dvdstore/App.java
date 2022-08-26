package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;


import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MovieController movieController = new MovieController();
        movieController.addMovieUsingConsole();

    }
}
