package com.example.fastcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fastcode.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
