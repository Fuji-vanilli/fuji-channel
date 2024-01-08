package com.fujichanel.castingservice.EntityMapper;

import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;
import com.fujichanel.castingservice.entities.Casting;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CastingMapperImpl implements CastingMapper{
    @Override
    public Casting mapToCasting(CastingRequest request) {
        return Casting.builder()
                .name(request.getName())
                .character(request.getCharacter())
                .profilePath(request.getProfilePath())
                .build();
    }

    @Override
    public CastingResponse mapToCastingResponse(Casting casting) {
        return CastingResponse.builder()
                .id(casting.getId())
                .name(casting.getName())
                .character(casting.getCharacter())
                .profilePath(casting.getProfilePath())
                .build();
    }
}
