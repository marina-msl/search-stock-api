package com.mml.search_stock_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mml.search_stock_api.dto.StockDetailed;
import com.mml.search_stock_api.dto.StockMinDTO;
import com.mml.search_stock_api.service.StockService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "stocks")
public class StockController {

    @Autowired
    private StockService service;

    @CrossOrigin(origins = "http://localhost:5000")
    @GetMapping(value = "/{code}")
    public Mono<ResponseEntity<StockMinDTO>> findByCode(@PathVariable String code) {
        return  service.findByCode(code)
            .flatMap(stockDto -> {  
                List<StockDetailed> results = stockDto.getResults();
                return filterResultByCode(results, code);
        })
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    private Mono<ResponseEntity<StockMinDTO>> filterResultByCode(List<StockDetailed> results, String code) {
        return results.stream()
            .filter(result -> result.getSymbol().equalsIgnoreCase(code))
            .findFirst()
            .map(result -> Mono.just(ResponseEntity.ok(new StockMinDTO(result))))
            .orElse(Mono.just(ResponseEntity.notFound().build()));
    }
}
