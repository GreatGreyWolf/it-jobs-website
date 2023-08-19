package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "employmenttype")
public class EmploymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the employmentTypeName
     */
    public String getEmploymentTypeName() {
        return employmentTypeName;
    }

    /**
     * @param employmentTypeName the employmentTypeName to set
     */
    public void setEmploymentTypeName(String employmentTypeName) {
        this.employmentTypeName = employmentTypeName;
    }

    @Column(name = "employment_type_name")
    private String employmentTypeName;

}
