package com.mutti.currencyexchangeservice.Repository;

import com.mutti.currencyexchangeservice.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
