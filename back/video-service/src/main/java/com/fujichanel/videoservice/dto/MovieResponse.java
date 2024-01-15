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
public class MovieResponse {
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
    private String id;
    private boolean adult;
    private Integer vote_count;
}
