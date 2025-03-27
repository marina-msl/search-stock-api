package com.mml.search_stock_api.dto;

import java.util.List;

public class StockDTO {
    private List<Result> results; 
    private String requestedAt; 
    private String took;



    public List<Result> getResults () {
        return this.results;
    }
}
