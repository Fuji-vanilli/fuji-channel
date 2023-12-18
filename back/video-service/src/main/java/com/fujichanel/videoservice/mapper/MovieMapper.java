package com.fujichanel.videoservice.mapper;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.entities.Movie;

public interface MovieMapper {
    Movie mapToMovie(MovieRequest request);
    MovieResponse mapToMovieResponse(Movie movie);
}
