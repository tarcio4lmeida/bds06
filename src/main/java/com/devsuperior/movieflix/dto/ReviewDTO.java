package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private Long movieId;
    private UserDTO user;

    private MovieDTO movie;

    @NotBlank
    private String text;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, Long movieId, UserDTO user, MovieDTO movie, String text) {
        this.movieId = movieId;
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.text = text;
    }

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.movieId = review.getMovie().getId();
        this.user = new UserDTO(review.getUser());
        this.movie = new MovieDTO(review.getMovie());
        this.text = review.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}