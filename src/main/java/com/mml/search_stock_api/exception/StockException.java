package com.mml.search_stock_api.exception;

public class StockException extends RuntimeException{

    public StockException(String msg) {
        System.out.println(msg);
    }

    public StockException(String msg, Exception e) {
        System.out.println(msg);
        System.out.println(e);
    }

}
