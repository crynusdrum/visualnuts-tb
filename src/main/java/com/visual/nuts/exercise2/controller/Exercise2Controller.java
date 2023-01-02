package com.visual.nuts.exercise2.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visual.nuts.exercise2.request.CountryRequest;

@RestController
@RequestMapping("/country")
public class Exercise2Controller {


	/**
	 * 
	 * @param requestList
	 * @return
	 * 
	 * - returns the number of countries in the world
	 */
	@PostMapping("/exercise2a")
	public String exercice2a(@RequestBody List<CountryRequest> requestList ) {

		int countCountry = 0;
		
		for (CountryRequest countryRequest : requestList) {
			if(countryRequest.getCountry() != null) {
				countCountry ++;
			}
		}
		
		return "The number of countries in the world: " + countCountry;
		
	}	
	
	/**
	 * 
	 * @param requestList
	 * @return
	 * 
	 * - finds the country with the most official languages, where they officially speak German (de).
	 */
	@PostMapping("/exercise2b")
	public String exercice2b(@RequestBody List<CountryRequest> requestList ) {

		Map<String, Integer> map = new HashMap<>();
		
		for (CountryRequest countryRequest : requestList) {
			if(!countryRequest.getLanguages().isEmpty() && countryRequest.getLanguages().contains("de")) {
				map.put(countryRequest.getCountry(), countryRequest.getLanguages().size());
			}
		}
		
		String key = map.entrySet().stream().max((entry1, entry2) -> 
												entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		
		return "The country with the most official languages, where speak German: "+key;
		
	}
	
	/**
	 * 
	 * @param requestList
	 * @return
	 * 
	 * - that counts all the official languages spoken in the listed countries.
	 */
	@PostMapping("/exercise2c")
	public String exercice2c(@RequestBody List<CountryRequest> requestList ) {


		HashSet<String> languageSet = new HashSet<>();

		for (CountryRequest countryRequest : requestList) {
			if(countryRequest.getCountry() != null && !countryRequest.getLanguages().isEmpty()) {
				for (String language : countryRequest.getLanguages()) {
					languageSet.add(language);
				}
			}
		}

		return "That counts all the official languages spoken in the listed countries: "+languageSet.size();

	}
	
	/**
	 * 
	 * @param requestList
	 * @return
	 * 
	 * - to find the country with the highest number of official languages.
	 */
	@PostMapping("/exercise2d")
	public String exercice2d(@RequestBody List<CountryRequest> requestList ) {

		Map<String, Integer> map = new HashMap<>();
		
		for (CountryRequest countryRequest : requestList) {
			if(!countryRequest.getLanguages().isEmpty()) {
				map.put(countryRequest.getCountry(), countryRequest.getLanguages().size());
			}
		}
		
		String key = map.entrySet().stream().max((entry1, entry2) -> 
												entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		
		return "the country with the highest number of official languages: "+key;
		
	}
	
	/**
	 * 
	 * @param requestList
	 * @return
	 * 
	 * - to find the most common official language(s), of all countries.
	 */
	@PostMapping("/exercise2e")
	public String exercice2e(@RequestBody List<CountryRequest> requestList ) {

		HashSet<String> languageSet = new HashSet<>();
		HashSet<String> commonLaguageSet = new HashSet<>();

		for (CountryRequest countryRequest : requestList) {
			if(countryRequest.getCountry() != null && !countryRequest.getLanguages().isEmpty()) {
				for (String language : countryRequest.getLanguages()) {					
					boolean added = languageSet.add(language);
					if (!added) {
						commonLaguageSet.add(language);
					}
				}
			}
		}
		
		return "Find the most common official language(s), of all countries: " +commonLaguageSet;
		
	}	


}
