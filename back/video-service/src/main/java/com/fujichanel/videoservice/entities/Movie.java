package com.fujichanel.videoservice.entities;

import com.fujichanel.videoservice.model.Cast;
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
    private String description;
    private String original_language;
    private String original_title;
    private boolean video;
    private String title;
    private Set<Integer> genre_ids;
    private String poster_path;
    private String media_type;
    private Date release_date;
    private String backdrop_path;
    private Integer popularity;
    private Double vote_average;
    private boolean adult;
    private Integer vote_count;
}
