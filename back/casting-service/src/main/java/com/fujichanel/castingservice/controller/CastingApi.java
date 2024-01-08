package com.fujichanel.castingservice.controller;

import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;
import com.fujichanel.castingservice.services.CastingService;
import com.fujichanel.castingservice.webClient.WebClientCastingGetter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.fujichanel.castingservice.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class CastingApi implements CastingController {
    private final CastingService castingService;
    private final WebClientCastingGetter webClient;

    @Override
    public ResponseEntity<CastingResponse> add(CastingRequest request) {
        return ResponseEntity.ok(castingService.add(request));
    }

    @Override
    public ResponseEntity<CastingResponse> get(String id) {
        return ResponseEntity.ok(castingService.get(id));
    }

    @Override
    public ResponseEntity<Set<CastingResponse>> all(int page, int size) {
        return ResponseEntity.ok(castingService.all(page, size));
    }

    @Override
    public ResponseEntity<Set<CastingResponse>> castByMovie(String movieId) {
        return ResponseEntity.ok(castingService.castingByMovie(movieId));
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return ResponseEntity.ok(castingService.delete(id));
    }

    @Override
    public ResponseEntity<CastingResponse> update(CastingRequest request) {
        return ResponseEntity.ok(castingService.update(request));
    }
}
