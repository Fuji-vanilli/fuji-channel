package com.fujichanel.videoservice.service;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;

import java.util.Set;

public interface MovieService {
    String stringApi();
    MovieResponse add(MovieRequest request);
    MovieResponse get(String id);
    Set<MovieResponse> all(int page, int size);
    boolean delete(String id);
}
