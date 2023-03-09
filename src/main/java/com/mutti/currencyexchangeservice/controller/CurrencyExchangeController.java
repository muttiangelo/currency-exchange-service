package com.mutti.currencyexchangeservice.controller;

import com.mutti.currencyexchangeservice.entities.CurrencyExchange;
import com.mutti.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from,
                                                @PathVariable String to) {
        return currencyExchangeService.getCurrencyExchangeByFromAndTo(from.toUpperCase(), to.toUpperCase());
    }

    @PostMapping("insert-currency")
    public List<CurrencyExchange> insertCurrencyExchange(@RequestBody List<CurrencyExchange> cu){
        return currencyExchangeService.insertCurrency(cu);
        }

    @GetMapping("findAll")
    public List<CurrencyExchange> findAllCurrencies() {
        return currencyExchangeService.findAll();
    }
}
