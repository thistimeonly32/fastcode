package com.example.fastcode.service;

import java.util.List;

import com.example.fastcode.dto.CompanyRequest;
import com.example.fastcode.dto.CompanyResponse;
import com.example.fastcode.util.DeleteAPIResponse;

public interface CompanyService {

	public List<CompanyResponse> findAll();

	public CompanyResponse findById(Long companyId);

	public CompanyResponse save(CompanyRequest companyRequest);

	public CompanyResponse update(CompanyRequest companyRequest);

	public DeleteAPIResponse deleteById(Long companyId);

}
