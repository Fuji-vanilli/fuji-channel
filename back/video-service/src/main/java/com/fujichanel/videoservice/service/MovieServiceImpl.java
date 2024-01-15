package com.fujichanel.videoservice.service;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.entities.Movie;
import com.fujichanel.videoservice.mapper.MovieMapper;
import com.fujichanel.videoservice.repository.MovieRepository;
import com.fujichanel.videoservice.webClientApi.ApiMovie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    private final MovieMapper mapper;
    private final ApiMovie apiMovie;

    @Override
    public Set<MovieResponse> stringApi() {
        return apiMovie.getMovie().stream()
                .map(mapper::mapToMovieResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<MovieResponse> addFromTmdb() {
        final Set<Movie> movies = apiMovie.getMovie();
        movieRepository.saveAll(movies);

        return movies.stream()
                .map(mapper::mapToMovieResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public MovieResponse add(MovieRequest request) {

        return null;
    }

    @Override
    public MovieResponse get(String id) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't find movie with the id: " + id));

        return null;
    }

    @Override
    public Set<MovieResponse> all(int page, int size) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
