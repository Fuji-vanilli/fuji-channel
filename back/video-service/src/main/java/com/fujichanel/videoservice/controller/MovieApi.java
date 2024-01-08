package com.fujichanel.videoservice.controller;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.entities.Movie;
import com.fujichanel.videoservice.security.JwtAuthConverter;
import com.fujichanel.videoservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.fujichanel.videoservice.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieApi implements MovieController{
    private final MovieService movieService;
    private final JwtAuthConverter jwtAuthConverter;


    @Override
    public Collection<String> getAuthorities() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    @Override
    public ResponseEntity<Map<String, String>> getAuth() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(Map.of(
                "authentication_token",authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(" "))
        ));
    }

    @Override
    public ResponseEntity<MovieResponse> add(MovieRequest request) {
        return ResponseEntity.ok(movieService.add(request));
    }

    @Override
    public ResponseEntity<Set<MovieRequest>> getMovie() {
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
