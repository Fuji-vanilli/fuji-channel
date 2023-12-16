package com.fujichanel.videoservice.model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Cast {
    private String id;
    private String name;
    private String character;
}
