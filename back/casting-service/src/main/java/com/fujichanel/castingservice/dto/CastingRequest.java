package com.fujichanel.castingservice.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CastingRequest {
    private String name;
    private String character;
    private String profilePath;
}
