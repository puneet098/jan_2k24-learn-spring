package com.example.rest.webservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
/**
 * SomeBean illustrates static filtering.
 * @JsonIgnoreProperties is provided at class-level.
 * @JsonIgnoreProperties("field1"):: filed1 will not be
 * displayed.
 * @JsonIgnore is done on property-level.
 * 
 */
//@JsonIgnoreProperties({"field1","field3"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String field1;
	//@JsonIgnore
	private String field2;
	
	private String field3;
	
	private String field4;
	
	private String field5;
	
	public SomeBean(String field1, String field2, String field3, String field4, String field5) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.field4 = field4;
		this.field5 = field5;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	public String getField4() {
		return field4;
	}
	public String getField5() {
		return field5;
	}
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4=" + field4
				+ ", field5=" + field5 + "]";
	}
	
	
	
	
	
	
	
}
