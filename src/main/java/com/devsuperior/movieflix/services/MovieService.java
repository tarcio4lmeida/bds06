package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public MovieDTO findbyId(Long id) {
        return repository.findById(id)
                .map(MovieDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    }

    public Page<MovieDTO> findMoviesByGenre(Long id, Pageable pageable) {
        Genre genre = (id == 0) ? null : genreRepository.getOne(id);
        return repository.findMoviesByGenre(genre, pageable).map(MovieDTO::new);
    }

    public MovieDTO findMovieReviews(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        List<Review> reviews = reviewRepository.find(movie);

        return new MovieDTO(movie, reviews);
    }
}
