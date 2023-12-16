package com.fujichanel.videoservice.controller;

import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface MovieController {
    @PostMapping("add")
    ResponseEntity<MovieResponse> add(@RequestBody MovieRequest request);
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
