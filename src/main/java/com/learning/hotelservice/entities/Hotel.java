package com.learning.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
public class Hotel {
	@Id
	@Column(name = "ID")
	private String hotelId;
	@Column(name = "NAME")
	@JsonProperty("Hotel_Name")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "LOCATION")
	private String location;
}
