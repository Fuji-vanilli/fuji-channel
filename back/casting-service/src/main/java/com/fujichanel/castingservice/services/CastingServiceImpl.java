package com.fujichanel.castingservice.services;

import com.fujichanel.castingservice.EntityMapper.CastingMapper;
import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;
import com.fujichanel.castingservice.repositories.CastingRepository;
import com.fujichanel.castingservice.webClient.WebClientCastingGetter;
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
public class CastingServiceImpl implements CastingService {
    private final CastingRepository castingRepository;
    private final WebClientCastingGetter webClientCastingGetter;
    private final CastingMapper castingMapper;
    @Override
    public CastingResponse add(CastingRequest request) {
        return null;
    }

    @Override
    public CastingResponse update(CastingRequest request) {
        return null;
    }

    @Override
    public Set<CastingResponse> castingByMovie(String movieId) {
        final Set<CastingRequest> casting = webClientCastingGetter.getCasting(movieId);

        return casting.stream()
                .map(cast-> castingMapper.mapToCastingResponse(castingMapper.mapToCasting(cast)))
                .collect(Collectors.toSet());
    }

    @Override
    public CastingResponse get(String id) {
        return null;
    }

    @Override
    public Set<CastingResponse> all(int page, int size) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }
}
