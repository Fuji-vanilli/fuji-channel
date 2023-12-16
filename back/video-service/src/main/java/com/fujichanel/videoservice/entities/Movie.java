package com.fujichanel.videoservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "movie")
public class Movie {
    @Id
    private String id;
    private String title;
    private BigDecimal duration;
    private Set<Long> genreId= ConcurrentHashMap.newKeySet();
    private String originalLanguage;
    private String description;
    private Date releaseDate;
    private BigDecimal vote;
    private BigDecimal count;
    private String posterPath;
    private BigDecimal popularity;
}
