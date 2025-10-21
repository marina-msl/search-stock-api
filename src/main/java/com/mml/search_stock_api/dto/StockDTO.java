package com.mml.search_stock_api.dto;

import java.util.List;

public class StockDTO {
    private List<StockDetailed> results; 
    private String requestedAt; 
    private String took;

    public List<StockDetailed> getResults () {
        return this.results;
    }
}
