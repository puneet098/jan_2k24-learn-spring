package com.example.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params="v1")
	public PersonV1 getPersonV1viaRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/headers", headers="X-API-VERSION=1")
	public PersonV1 getPersonV1viaRequestHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces="application/app-v1+json")
	public PersonV1 getPersonV1viaRequestAcceptHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob" , "Charlie"));
	}
	
	@GetMapping(path = "/person", params="v2")
	public PersonV2 getPersonV2viaRequestParameter() {
		return new PersonV2(new Name("Bob" , "Charlie"));
	}
	
	@GetMapping(path = "/person/headers", headers="X-API-VERSION=2")
	public PersonV2 getPersonV2viaRequestHeaders() {
		return new PersonV2(new Name("Bob" , "Charlie"));
	}
	@GetMapping(path = "/person/accept", produces="application/app-v2+json")
	public PersonV2 getPersonV2viaRequestAcceptHeaders() {
		return new PersonV2(new Name("Bob" , "Charlie"));
	}
}
