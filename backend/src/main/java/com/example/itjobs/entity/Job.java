package com.example.itjobs.entity;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "todo")
    private String todo;

    @Column(name = "location")
    private String location;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "work_percentage")
    private Integer workPercentage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MethodCategory methodCategory;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private JobRequirement jobRequirement;

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
     * @return the title
     */
    public String getTitle() {
      return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
      this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
      return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
      this.description = description;
    }

    /**
     * @return the todo
     */
    public String getTodo() {
      return todo;
    }

    /**
     * @param todo the todo to set
     */
    public void setTodo(String todo) {
      this.todo = todo;
    }

    /**
     * @return the location
     */
    public String getLocation() {
      return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
      this.location = location;
    }

    /**
     * @return the salary
     */
    public BigDecimal getSalary() {
      return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(BigDecimal salary) {
      this.salary = salary;
    }

    /**
     * @return the workPercentage
     */
    public Integer getWorkPercentage() {
      return workPercentage;
    }

    /**
     * @param workPercentage the workPercentage to set
     */
    public void setWorkPercentage(Integer workPercentage) {
      this.workPercentage = workPercentage;
    }

    /**
     * @return the methodCategory
     */
    public MethodCategory getMethodCategory() {
      return methodCategory;
    }

    /**
     * @param methodCategory the methodCategory to set
     */
    public void setMethodCategory(MethodCategory methodCategory) {
      this.methodCategory = methodCategory;
    }

    /**
     * @return the role
     */
    public Role getRole() {
      return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
      this.role = role;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
      return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
      this.company = company;
    }

    /**
     * @return the employmentType
     */
    public EmploymentType getEmploymentType() {
      return employmentType;
    }

    /**
     * @param employmentType the employmentType to set
     */
    public void setEmploymentType(EmploymentType employmentType) {
      this.employmentType = employmentType;
    }

    /**
     * @return the jobRequirement
     */
    public JobRequirement getJobRequirement() {
      return jobRequirement;
    }

    /**
     * @param jobRequirement the jobRequirement to set
     */
    public void setJobRequirement(JobRequirement jobRequirement) {
      this.jobRequirement = jobRequirement;
    }
}
