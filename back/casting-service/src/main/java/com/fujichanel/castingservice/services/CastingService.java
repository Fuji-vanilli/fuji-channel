package com.fujichanel.castingservice.services;

import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;

import java.util.Set;

public interface CastingService {
    CastingResponse add(CastingRequest request);
    CastingResponse update(CastingRequest request);
    Set<CastingResponse> castingByMovie(String movieId);
    CastingResponse get(String id);
    Set<CastingResponse> all(int page, int size);
    Boolean delete(String id);
}
