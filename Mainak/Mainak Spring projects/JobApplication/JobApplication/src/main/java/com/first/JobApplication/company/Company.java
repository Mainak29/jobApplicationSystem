package com.first.JobApplication.company;


import com.first.JobApplication.job.Job;
import com.first.JobApplication.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    public Company(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String companyDescription;
    private String location;

    @OneToMany
    private List<Job> jobs;
    @OneToMany
    private List<Review> reviews;

    public Company(Long id, String name, String companyDescription, String location) {
        this.id = id;
        this.name = name;
        this.companyDescription = companyDescription;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
