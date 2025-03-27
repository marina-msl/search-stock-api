package com.mml.search_stock_api.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mml.search_stock_api.dto.StockDTO;
import com.mml.search_stock_api.exception.StockException;

@Service
public class StockService {

    public StockDTO findByCode(String code) {
        
        String url = buildUrl(code);
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new StockException("Failed to fetch stock data for: " + code, e);
        }
        
        if (response.statusCode() != 200 || response.body().contains("Error")) {
            throw new StockException("Error: stock not found");
        }
        Gson gson = new GsonBuilder().create();
        
        StockDTO stockRequested = gson.fromJson(response.body(), StockDTO.class);
        
        System.out.println("The code is "  + code);
        return stockRequested;
    }

    private String buildUrl(String code) {
        return "https://brapi.dev/api/quote/" + code
        + "?range=5d&interval=1d&fundamental=true&dividends=false&token=dm5Q62W9vhrM82bqq9SywZ";
    }
    
}
