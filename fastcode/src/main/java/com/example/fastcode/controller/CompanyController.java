package com.example.fastcode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcode.dto.CompanyRequest;
import com.example.fastcode.dto.CompanyResponse;
import com.example.fastcode.repository.CompanyRepository;
import com.example.fastcode.service.CompanyService;
import com.example.fastcode.util.DeleteAPIResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@Autowired
	CompanyRepository companyRepository;

	@ApiOperation(value = "Get List of all Companies")
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CompanyResponse>> findAll() {

		return new ResponseEntity<List<CompanyResponse>>(companyService.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get a company by id (PK)")
	@GetMapping(path = "/{companyId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CompanyResponse> findById(@PathVariable Long companyId) {
		return new ResponseEntity<CompanyResponse>(companyService.findById(companyId), HttpStatus.OK);
	}

	@ApiOperation(value = "Create a Company")
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CompanyResponse> save(@Valid @RequestBody CompanyRequest companyRequest) {
		return new ResponseEntity<CompanyResponse>(companyService.save(companyRequest), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update a company")
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CompanyResponse> update(@Valid @RequestBody CompanyRequest companyRequest) {
		return new ResponseEntity<CompanyResponse>(companyService.update(companyRequest), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a company by companyId (PK)")
	@DeleteMapping(path = "/{companyId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DeleteAPIResponse> delete(@PathVariable Long companyId) {
		return new ResponseEntity<DeleteAPIResponse>(companyService.deleteById(companyId), HttpStatus.OK);
	}

}
