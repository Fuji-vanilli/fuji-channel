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
                .title(request.getTitle())
                .duration(request.getDuration())
                .releaseDate(request.getReleaseDate())
                .description(request.getDescription())
                .posterPath(request.getPosterPath())
                .genreId(request.getGenreId())
                .cast(request.getCast())
                .build();
    }
    @Override
    public MovieResponse mapToMovieResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .cast(movie.getCast())
                .count(movie.getCount())
                .duration(movie.getDuration())
                .genreId(movie.getGenreId())
                .originalLanguage(movie.getOriginalLanguage())
                .popularity(movie.getPopularity())
                .vote(movie.getVote())
                .build();
    }
}

