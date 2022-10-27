package com.example.moviecatalogservice.repos;

import com.example.moviecatalogservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
