package com.mml.search_stock_api.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mml.search_stock_api.dto.StockDTO;

import reactor.core.publisher.Mono;

@Service
public class StockService {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://brapi.dev/api/quote/")
            .build();
            
   public Mono<StockDTO> findByCode(String code) {

    String url = buildUrl(code);

    return webClient.get()
            .uri(url)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(
                status -> !status.is2xxSuccessful(),
                response -> response.bodyToMono(String.class)
                    .doOnNext(body -> System.out.println("Error : " + body))
                    .then(Mono.empty())
            )
            .bodyToMono(StockDTO.class);
    }

    private String buildUrl(String code) {
        return code + "?range=5d&interval=1d&fundamental=true&dividends=false&token=dm5Q62W9vhrM82bqq9SywZ";
    }
}
