package com.mml.search_stock_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mml.search_stock_api.dto.StockDTO;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Mono;

@Service
public class StockService {

    @Value("${baseUrl}")
    private String baseUrl;
    @Value("${stockUrl}")
    private String stockUrl;

    private  WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

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
        return code + stockUrl;
    }
}
