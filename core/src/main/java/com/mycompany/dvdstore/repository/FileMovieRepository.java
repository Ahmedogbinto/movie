package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepository implements MovieRepositoryInterface{
    @Value("${movie.file.location}") private File file;
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void add(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);   // instanciation du FileWriter encours, pour utiliser l'objet de type File afin d'écrire dans un fichier
            writer.write(movie.getTitle()+";"+movie.getGenre()+"\n");
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Fichier txt: Le titre du film est "+movie.getTitle()+" et son genre est "+movie.getGenre());
    }
}
