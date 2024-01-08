package com.fujichanel.castingservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "casting")
public class Casting {
    @Id
    private String id;
    private String name;
    private String character;
    private String profilePath;
    private String movieId;
}
