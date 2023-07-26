package com.learning.hotelservice.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "currency_exchange_table")
public class ExchangeValue {

	@Id
	@Column(name = "ID")
	private String id;
	@Column(name= "currency_from")
	private String from;
	@Column(name= "currency_to")
	private String to;
	@Column(name= "conversion_multiple")
	private BigDecimal conversionMultiple;
}
