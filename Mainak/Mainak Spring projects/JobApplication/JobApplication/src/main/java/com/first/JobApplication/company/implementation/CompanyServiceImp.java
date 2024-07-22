package com.first.JobApplication.company.implementation;

import com.first.JobApplication.company.Company;
import com.first.JobApplication.company.CompanyRepository;
import com.first.JobApplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    CompanyRepository companyRepository;


    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompaniesById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
