package com.example.fastcode.util;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.fast.exception.RecordNotFoundException;
import com.example.fastcode.model.Company;
import com.example.fastcode.repository.CompanyRepository;

@Component
@Transactional
public class EntityFinder {

	@Autowired
	CompanyRepository companyRepository;

	public Company findCompanyByCompanyId(Long companyId) {
		Optional<Company> company = companyRepository.findById(companyId);
		if (!company.isPresent()) {
			throw new RecordNotFoundException(Constant.COMPANY_NOT_FOUND);
		}
		return company.get();
	}

}
