package com.fujichanel.videoservice.controller;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MovieController {
    @GetMapping("authentication")
    Collection<String> getAuthorities();
    @GetMapping("auth")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    ResponseEntity<Map<String, String>> getAuth();
    @PostMapping("add")
    ResponseEntity<MovieResponse> add(@RequestBody MovieRequest request);
    @GetMapping("getMovie")
    ResponseEntity<Set<MovieResponse>> getMovie();
    @GetMapping("get/{id}")
    ResponseEntity<MovieResponse> get(@PathVariable String id);
    @GetMapping("all")
    ResponseEntity<Set<MovieResponse> > all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );
    @DeleteMapping("delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable String id);

}
