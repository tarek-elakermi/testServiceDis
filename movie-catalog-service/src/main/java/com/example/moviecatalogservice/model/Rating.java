package com.example.moviecatalogservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long movieId;
    private int rating;

    public Rating() {
    }

    public Rating(Long movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Rating(int rating) {
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }
}
