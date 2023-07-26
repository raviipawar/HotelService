package com.learning.hotelservice.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.hotelservice.entities.ExchangeValue;
import com.learning.hotelservice.repositories.CurrencyExchangeRepo;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;

	public ExchangeValue saveExchangeValue(ExchangeValue exchangeValue) {
		String randomHotelId= UUID.randomUUID().toString();
		exchangeValue.setId(randomHotelId);
		return currencyExchangeRepo.save(exchangeValue);
	}

	public ExchangeValue findByFromAndTo(String from, String to) {
		ExchangeValue exchangeValue = currencyExchangeRepo.findByFromAndTo(from, to);
		return exchangeValue;
	}
}
