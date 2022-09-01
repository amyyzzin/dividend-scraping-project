package com.tistory.amyyzzin.dividend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@GetMapping("/autocomplete")
	public ResponseEntity<?> autocomplete(@RequestParam String keyword) {
		return null;
	}

	@GetMapping
	public ResponseEntity<?> searchCompany() {
		return null;
	}

	@GetMapping
	public ResponseEntity<?> addCompany() {
		return null;
	}

	@GetMapping
	public ResponseEntity<?> deleteCompany() {
		return null;
	}
}
