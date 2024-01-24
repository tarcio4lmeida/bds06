package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;

public class ReviewDTO  implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;


    private UserDTO user;

    private MovieDTO movie;

    private String text;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, UserDTO user, MovieDTO movie, String text) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.text = text;
    }

    public ReviewDTO(Review review) {
        this.id = review.getId();
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
}