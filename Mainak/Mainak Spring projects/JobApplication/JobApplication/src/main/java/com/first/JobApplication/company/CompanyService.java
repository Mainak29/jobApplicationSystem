package com.first.JobApplication.company;

import java.util.List;

public interface CompanyService
{
    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company getCompaniesById(Long id);

    boolean deleteCompanyById(Long id);

    boolean putCompanyById(Company company, Long id);
}
