package com.example.rest.webservices.filtering;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	private FilterProvider filters;
	/*
	 * feild1,feild3 will not be displayed due to dynamic filtering.
	 * MappingJacksonValue, SimpleBeanPropertyFilter
	 *  FilterProvider, SimpleFilterProvider will be doing dynamic filtering.
	 * 
	 */
	@GetMapping("/filtering")//feild1,feild3
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1","value2","value3","value4","value5");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		//String [] valuesArray = {"field1","field3","field5"};
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field4","field5");		
		//FilterProvider filters  = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		this.filters = getFilters("field1","field3","field5");
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
	
	
	/*
	 * feild2,feild4 will not be displayed due to dynamic filtering
	 * in the list.
	 * This is dynamic Filtering 
	 */
	@GetMapping("/filtering-list")
	public  MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3","value4","value5"),
				new SomeBean("value4","value5","value6","value7","value8"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");		
		//FilterProvider filters  = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		String [] valuesArray = {"field1","field3"};
		this.filters = getFilters(valuesArray);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}


	private FilterProvider getFilters(String... valuesArray) {
		//HashSet<String> valueSet = new HashSet<String>(valuesArray.length);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(valuesArray);
        FilterProvider filters  = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		return filters;
	}
	
	
}
