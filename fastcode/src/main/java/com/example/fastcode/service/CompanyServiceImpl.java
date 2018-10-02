package com.example.fastcode.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fastcode.dto.CompanyRequest;
import com.example.fastcode.dto.CompanyResponse;
import com.example.fastcode.model.Company;
import com.example.fastcode.repository.CompanyRepository;
import com.example.fastcode.util.BeanMapperUtil;
import com.example.fastcode.util.DeleteAPIResponse;
import com.example.fastcode.util.EntityFinder;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	EntityFinder entityFinder;

	@Override
	public List<CompanyResponse> findAll() {
		log.info(">>>> Start of findAll");
		log.info(">>>> End of findAll");
		return new BeanMapperUtil().mapAsList(companyRepository.findAll(), CompanyResponse.class);
	}

	@Override
	public CompanyResponse findById(Long companyId) {
		log.info(">>>> Start of findById");
		Company company = entityFinder.findCompanyByCompanyId(companyId);
		System.out.println("here: " + company.getName());
		log.info(">>>> End of findById");
		return new BeanMapperUtil().map(company, CompanyResponse.class);
	}

	@Override
	public CompanyResponse save(CompanyRequest companyRequest) {
		log.info(">>>> Start of save");
		Company company = new Company();
		company.setName(companyRequest.getName());
		companyRepository.save(company);
		log.info(">>>> End of save");
		return new BeanMapperUtil().map(company, CompanyResponse.class);
	}

	@Override
	public CompanyResponse update(CompanyRequest companyRequest) {
		log.info(">>>> Start of update");
		Company company = entityFinder.findCompanyByCompanyId(companyRequest.getCompanyId());
		company.setName(companyRequest.getName());
		companyRepository.save(company);
		log.info(">>>> End of update");
		return new BeanMapperUtil().map(company, CompanyResponse.class);
	}

	@Override
	public DeleteAPIResponse deleteById(Long companyId) {
		log.info(">>>> Start of deleteById");
		Company company = entityFinder.findCompanyByCompanyId(companyId);
		companyRepository.delete(company);
		log.info(">>>> End of deleteById");
		return new DeleteAPIResponse(companyId);
	}

}
