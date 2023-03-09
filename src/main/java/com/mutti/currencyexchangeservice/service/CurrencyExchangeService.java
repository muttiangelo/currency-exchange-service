package com.mutti.currencyexchangeservice.service;

import com.mutti.currencyexchangeservice.Repository.CurrencyExchangeRepository;
import com.mutti.currencyexchangeservice.entities.CurrencyExchange;
import com.mutti.currencyexchangeservice.exception.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment env;

    public CurrencyExchange getCurrencyExchangeByFromAndTo(String from, String to) {
        CurrencyExchange ce = currencyExchangeRepository.findByFromAndTo(from, to);
        if (ce != null) {
            ce.setEnvironment(env.getProperty("server.port"));
            return ce;
        } else {
            throw new CurrencyNotFoundException("Couldn't find this currency exchange for the from/to sent");
        }
    }

    public List<CurrencyExchange> insertCurrency(List<CurrencyExchange> currencyExchange){
        currencyExchange.forEach(ce -> ce.setEnvironment(env.getProperty("server.port")));
        return currencyExchangeRepository.saveAll(currencyExchange);
    }

    public List<CurrencyExchange> findAll() {
        return currencyExchangeRepository.findAll();
    }
}
