package com.project.bootcamp.service.impl;

import com.project.bootcamp.dto.MovieRequest;
import com.project.bootcamp.entity.Movie;
import com.project.bootcamp.repository.MovieRepository;
import com.project.bootcamp.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public String save(MovieRequest request){
        saveToDB(request);
        return "Success";
    }

    @Override
    public String get(Long id){
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isPresent()){
            return "Success";
        } else {
            return "Data Not Found";
        }
    }

    private void saveToDB(MovieRequest request){
        Movie movie = new Movie();

        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setDirector(request.getDirector());
        movie.setRating(request.getRating());

        movieRepository.save(movie);
    }
}
