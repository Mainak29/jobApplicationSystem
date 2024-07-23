package com.first.JobApplication.company;


import com.first.JobApplication.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> putCompanyById(@PathVariable Long id, @RequestBody Company company){
        if(companyService.putCompanyById(company, id)){
            return new ResponseEntity<>(companyService.getCompaniesById(id),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id)
    {
        if(companyService.deleteCompanyById(id)){
            return new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompaniesById(@PathVariable Long id){
       Company company = companyService.getCompaniesById(id);
       if (company!=null){
           return new ResponseEntity<>(company,HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
}
