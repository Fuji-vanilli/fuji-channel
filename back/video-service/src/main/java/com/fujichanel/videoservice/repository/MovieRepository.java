package com.fujichanel.videoservice.repository;

import com.fujichanel.videoservice.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Page<Movie> findAll(Pageable pageable);
}
