package com.fujichanel.castingservice.webClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fujichanel.castingservice.dto.CastingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebClientCastingGetter {
    private final WebClient.Builder webClient;

    @Value("${movie.apiKey}")
    private String apiKey;
    @Value("${movie.url-cast}")
    private String movieUrl;

    public Set<CastingRequest> getCasting(String movieId) {
        final CompletableFuture<String> dataFuture = webClient.build().get()
                .uri(movieUrl+movieId,
                        uriBuilder -> uriBuilder
                                .path("/credits")
                                .queryParam("api_key", apiKey).build())
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        String castingFromFuture= "";
        String jsonObjectString = "";
        Set<CastingRequest> casting= new HashSet<>();

        try {
            castingFromFuture= dataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error to convert Future to string!!!");
        }

        try {
            JSONObject jsonObject= new JSONObject(castingFromFuture);
            jsonObjectString= jsonObject.getJSONArray("cast").toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper castingObjectMapper= new ObjectMapper();
        castingObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            final CastingRequest[] castingRequests = castingObjectMapper.readValue(jsonObjectString, CastingRequest[].class);
            casting.addAll(Arrays.asList(castingRequests));

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error to deserialize the json data!!!");
        }

        return casting;
    }

}
