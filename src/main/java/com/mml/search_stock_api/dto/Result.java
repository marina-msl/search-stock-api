package com.mml.search_stock_api.dto;

import java.util.List;

public class Result {
    
    private String currency; 
    private String shortName; 
    private String longName; 
    private double regularMarketChange; 
    private double regularMarketChangePercent; 
    private String regularMarketTime; 
    private double regularMarketPrice; 
    private double regularMarketDayHigh; 
    private String regularMarketDayRange; 
    private double regularMarketDayLow; 
    private int regularMarketVolume; 
    private double regularMarketPreviousClose; 
    private double regularMarketOpen; 
    private String fiftyTwoWeekRange; 
    private double fiftyTwoWeekLow; 
    private double fiftyTwoWeekHigh; 
    private String symbol; 
    private String usedInterval; 
    private String usedRange; 
    private List<HistoricalDataPrice> historicalDataPrice; 
    private List<String> validRanges; 
    private List<String> validIntervals; 
    private double priceEarnings; 
    private double earningsPerShare; 
    private String logourl;

    public String getCurrency() {
        return currency;
    }

    public String getShortName() {
        return shortName;
    }
    
    public String getLongName() {
        return longName;
    }

    public double getRegularMarketChange() {
        return regularMarketChange;
    }

    public double getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public String getRegularMarketTime() {
        return regularMarketTime;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public String getRegularMarketDayRange() {
        return regularMarketDayRange;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public int getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public double getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public double getRegularMarketOpen() {
        return regularMarketOpen;
    }

    public String getFiftyTwoWeekRange() {
        return fiftyTwoWeekRange;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getUsedInterval() {
        return usedInterval;
    }

    public String getUsedRange() {
        return usedRange;
    }

    public List<HistoricalDataPrice> getHistoricalDataPrice() {
        return historicalDataPrice;
    }

    public List<String> getValidRanges() {
        return validRanges;
    }

    public List<String> getValidIntervals() {
        return validIntervals;
    }

    public double getPriceEarnings() {
        return priceEarnings;
    }

    public double getEarningsPerShare() {
        return earningsPerShare;
    }

    public String getLogourl() {
        return logourl;
    }

}
