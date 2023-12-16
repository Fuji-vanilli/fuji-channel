package com.fujichanel.videoservice.dto;

import com.fujichanel.videoservice.model.Cast;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MovieRequest {
    private String title;
    private BigDecimal duration;
    private Set<Long> genreId= ConcurrentHashMap.newKeySet();
    private Set<Cast> cast= ConcurrentHashMap.newKeySet();
    private String originalLanguage;
    private String description;
    private Date releaseDate;
    private String posterPath;
}
