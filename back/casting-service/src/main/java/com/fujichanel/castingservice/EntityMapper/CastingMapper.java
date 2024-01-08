package com.fujichanel.castingservice.EntityMapper;

import com.fujichanel.castingservice.dto.CastingRequest;
import com.fujichanel.castingservice.dto.CastingResponse;
import com.fujichanel.castingservice.entities.Casting;

public interface CastingMapper {
    Casting mapToCasting(CastingRequest request);
    CastingResponse mapToCastingResponse(Casting casting);
}
