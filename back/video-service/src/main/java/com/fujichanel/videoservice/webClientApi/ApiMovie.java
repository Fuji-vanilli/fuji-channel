package com.fujichanel.videoservice.webClientApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fujichanel.videoservice.dto.MovieRequest;
import com.fujichanel.videoservice.dto.MovieResponse;
import com.fujichanel.videoservice.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Configuration
@RequiredArgsConstructor
@Validated
@ConfigurationProperties(prefix = "movie.api")
public class ApiMovie {
    @Value("${movie.api-key}")
    private String apiKey;
    @Value("${movie.url-movie}")
    private String movieUrl;
    private final WebClient.Builder webClient;

    public Set<Movie> getMovie() {
        final CompletableFuture<String> dataFuture = webClient.build().get()
                .uri(movieUrl, uriBuilder -> uriBuilder.path("/trending/all/week")
                        .queryParam("api_key", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        String dataBrute= "";
        Set<Movie> movies= new HashSet<>();
        JSONArray results= null;

        try {
            dataBrute= dataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Can't convert future data to String!!!");
        }

        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JSONObject dataJson= new JSONObject(dataBrute);
            results= dataJson.getJSONArray("results");

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        try {
            final Movie[] movies1 = objectMapper.readValue(results.toString(), Movie[].class);
            movies.addAll(Arrays.asList(movies1));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }
}
