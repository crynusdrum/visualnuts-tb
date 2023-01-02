package com.visual.nuts.exercise2.request;

import java.util.List;

import lombok.Data;

@Data
public class CountryRequest {
	
	private String country;
	private List<String> languages;


}
