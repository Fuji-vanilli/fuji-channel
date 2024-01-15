package com.fujichanel.videoservice.mapper;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.entities.Movie;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieMapperImpl implements MovieMapper {
    @Override
    public Movie mapToMovie(MovieRequest request) {
        return Movie.builder()

                .build();
    }
    @Override
    public MovieResponse mapToMovieResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .popularity(movie.getPopularity())
                .adult(movie.isAdult())
                .video(movie.isVideo())
                .backdrop_path(movie.getBackdrop_path())
                .media_type(movie.getMedia_type())
                .build();
    }
}

