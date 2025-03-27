package com.mml.search_stock_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mml.search_stock_api.dto.Result;
import com.mml.search_stock_api.dto.StockDTO;
import com.mml.search_stock_api.dto.StockMinDTO;
import com.mml.search_stock_api.service.StockService;

@RestController
@RequestMapping(value = "stocks")
public class StockController {

    @Autowired
    private StockService service;

    @CrossOrigin(origins = "http://localhost:5000")
    @GetMapping(value = "/{code}")
    public ResponseEntity<StockMinDTO> findByCode(@PathVariable String code) {
        StockDTO stockDto = service.findByCode(code);
        List<Result> results = stockDto.getResults();

        if (results == null || results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

       return  results.stream()
                    .filter(result -> result.getSymbol().equalsIgnoreCase(code))
                    .findFirst()
                    .map(result -> ResponseEntity.ok(new StockMinDTO(result)))
                    .orElse(ResponseEntity.notFound().build());

    }
}
