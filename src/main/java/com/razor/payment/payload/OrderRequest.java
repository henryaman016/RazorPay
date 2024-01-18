package com.razor.payment.payload;

public class OrderRequest {

    private long amount;

    private String currency;

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
