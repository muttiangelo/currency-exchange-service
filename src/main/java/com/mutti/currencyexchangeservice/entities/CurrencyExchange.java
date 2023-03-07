package com.mutti.currencyexchangeservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {

    @Id
    private long id;
    @Column(name= "currency_from")
    private String from;

    @Column(name= "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public CurrencyExchange() {

    }

    public CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
