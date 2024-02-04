package com.example01.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyConfigurationController {

	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@GetMapping("/currency-configuration")
	public CurrencyServiceConfiguration retrieveCurrencyServiceConfig() {
		return configuration;
	}
}
