package com.mml.search_stock_api.dto;


public class StockMinDTO {

    private String code;
    private String currency;
    private Double price;
    private String shortName;


    public StockMinDTO(Result result){
        this.code = result.getSymbol();
        this.currency = result.getCurrency();
        this.price = result.getRegularMarketPrice();
        this.shortName = result.getShortName();
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    
    
}
