package com.example.moviecatalogservice.repos;

import com.example.moviecatalogservice.model.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, Long> {
}
