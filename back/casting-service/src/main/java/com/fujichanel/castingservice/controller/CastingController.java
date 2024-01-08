package com.fujichanel.castingservice.controller;

import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface CastingController {
    @PostMapping("add")
    ResponseEntity<CastingResponse> add(@RequestBody CastingRequest request);
    @GetMapping("get/{id}")
    ResponseEntity<CastingResponse> get(@PathVariable String id);
    @GetMapping("all")
    ResponseEntity<Set<CastingResponse>> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
    @GetMapping("get/byMovie/{movieId}")
    ResponseEntity<Set<CastingResponse>> castByMovie(@PathVariable String movieId);
    @DeleteMapping("delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable String id);
    @PutMapping("update")
    ResponseEntity<CastingResponse> update(@RequestBody CastingRequest request);
}
