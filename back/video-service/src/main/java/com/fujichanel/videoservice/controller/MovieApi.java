package com.fujichanel.videoservice.controller;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.fujichanel.videoservice.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class MovieApi implements MovieController{
    private final MovieService movieService;
    @Override
    public ResponseEntity<MovieResponse> add(MovieRequest request) {
        return ResponseEntity.ok(movieService.add(request));
    }

    @Override
    public ResponseEntity<String> getMovie() {
        return ResponseEntity.ok(movieService.stringApi());
    }

    @Override
    public ResponseEntity<MovieResponse> get(String id) {
        return ResponseEntity.ok(movieService.get(id));
    }

    @Override
    public ResponseEntity<Set<MovieResponse>> all(int page, int size) {
        return ResponseEntity.ok(movieService.all(page, size));
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return ResponseEntity.ok(movieService.delete(id));
    }
}
