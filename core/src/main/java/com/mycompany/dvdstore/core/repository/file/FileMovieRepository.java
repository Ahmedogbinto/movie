package com.mycompany.dvdstore.core.repository.file;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {
    @Value("${movie.file.location}")
    private File file;
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public Movie save(Movie movie){

        // la methode save convertie le resultat de findAll en Stream(Dautres solutions sont possibles)
        long lastId= StreamSupport.stream(findAll().spliterator(),false).map(Movie::getId).max(Long::compare).orElse(0L);

        movie.setId(lastId+1);
        FileWriter writer;
        try{
            writer=new FileWriter(file, true);                    // instanciation du FileWriter encours, pour utiliser l'objet de type File afin d'écrire dans un fichier
            writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"+movie.getDescription()+"\n");
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Fichier txt: Le titre du film est "+movie.getTitle()+" et son genre est "+movie.getGenre());

    return movie;
    }

    @Override
    public Iterable<Movie> findAll() {
        List<Movie> movies= new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) !=null; ) {
                final Movie movie = new Movie();
                final String[] allProperties = line.split("\\;");

                movie.setId(Long.parseLong(allProperties[0]));
                movie.setTitle(allProperties[1]);
                movie.setGenre(allProperties[2]);

                movies.add(movie);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.err.println("A movie from the file does not have a proper id ");
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long id){
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            for (String line; (line = br.readLine()) !=null;){

                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if(nextMovieId==id){
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);

                    return Optional.of(movie);
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(NumberFormatException e){
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        movie.setTitle("UNKNOWN");
        movie.setGenre("UNKNOWN");
        movie.setDescription("UNKNOWN");
        return Optional.of(movie);
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();

    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }
}
