package com.fujichanel.videoservice.webClientApi;

import com.fujichanel.videoservice.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.fujichanel.videoservice.utils.Root.API_URL_TMDB;

@Configuration
@RequiredArgsConstructor
@Validated
@ConfigurationProperties(prefix = "movie.api")
public class ApiMovie {
    private String apiKey;
    private final WebClient.Builder webClient;

    public String getMovie() {
        return webClient.build().get()
                .uri("https://api.themoviedb.org/3", uriBuilder -> uriBuilder
                        .queryParam("apiKey", apiKey)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
