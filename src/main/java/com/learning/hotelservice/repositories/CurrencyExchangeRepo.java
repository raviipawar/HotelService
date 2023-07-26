package com.learning.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.hotelservice.entities.ExchangeValue;

public interface CurrencyExchangeRepo extends JpaRepository<ExchangeValue, String>{

	ExchangeValue findByFromAndTo(String from, String to);
}
