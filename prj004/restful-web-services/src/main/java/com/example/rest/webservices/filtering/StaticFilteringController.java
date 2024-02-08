package com.example.rest.webservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {

	/*
	 * field2 will not be displayed due to dynamic filtering.
	 * @JsonIgnore is put on field2 of SomeBean.
	 */
	@GetMapping("/static-filtering")
	public StaticFilterSomeBean filtering() {
		return new StaticFilterSomeBean("value1","value2","value3","value4","value5");
	}
	
	
	/*
	 * Due @JsonIgnore field2 will be ignored from displaying
	 * in the list.
	 * This is Static Filtering 
	 */
	@GetMapping("/static-filtering-list")
	public List<StaticFilterSomeBean> filteringList() {
		return Arrays.asList(new StaticFilterSomeBean("value1","value2","value3","value4","value5"),
				new StaticFilterSomeBean("value4","value5","value6","value7","value8"));
	}
}
