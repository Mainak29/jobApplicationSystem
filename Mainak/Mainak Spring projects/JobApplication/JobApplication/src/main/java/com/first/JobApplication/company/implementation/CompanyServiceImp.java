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

    @Override
    public boolean deleteCompanyById(Long id) {
        Company company = getCompaniesById(id);
        if (company == null){
            return false;
        }
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean putCompanyById(Company newCompany, Long id) {
        Company existingCompany = getCompaniesById(id);
        if(existingCompany == null){
            return false;
        }else{
            existingCompany.setName(newCompany.getName());
            existingCompany.setCompanyDescription(newCompany.getCompanyDescription());
            existingCompany.setLocation(newCompany.getLocation());
            companyRepository.save(existingCompany);
            return true;
        }
    }
}
