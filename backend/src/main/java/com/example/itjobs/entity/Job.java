package com.example.itjobs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

  @Column(name = "salary_min")
  @Min(1)
  @Max(1000000)
  private Integer salaryMin;

  @Column(name = "salary_max")
  @Min(1)
  @Max(1000000)
  private Integer salaryMax;

  @Column(name = "work_percentage_min")
  @Min(10)
  @Max(100)
  private Integer workPercentageMin;

  @Column(name = "work_percentage_max")
  @Min(10)
  @Max(100)
  private Integer workPercentageMax;

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

  @ManyToMany
  @JoinTable(name = "jobtechnology", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "technology_id"))
  private Set<Technology> technologies = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "jobmethod", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "method_id"))
  private Set<Method> methods = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "jobgoodie", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "goodie_id"))
  private Set<Goodie> goodies = new HashSet<>();

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
   * @return the salaryMin
   */
  public Integer getSalaryMin() {
    return salaryMin;
  }

  /**
   * @param salaryMin the salaryMin to set
   */
  public void setSalaryMin(Integer salaryMin) {
    this.salaryMin = salaryMin;
  }

  /**
   * @return the salaryMax
   */
  public Integer getSalaryMax() {
    return salaryMax;
  }

  /**
   * @param salaryMax the salaryMax to set
   */
  public void setSalaryMax(Integer salaryMax) {
    this.salaryMax = salaryMax;
  }

  /**
   * @return the workPercentageMin
   */
  public Integer getWorkPercentageMin() {
    return workPercentageMin;
  }

  /**
   * @param workPercentageMin the workPercentageMin to set
   */
  public void setWorkPercentageMin(Integer workPercentageMin) {
    this.workPercentageMin = workPercentageMin;
  }

  /**
   * @return the workPercentageMax
   */
  public Integer getWorkPercentageMax() {
    return workPercentageMax;
  }

  /**
   * @param workPercentageMax the workPercentageMax to set
   */
  public void setWorkPercentageMax(Integer workPercentageMax) {
    this.workPercentageMax = workPercentageMax;
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

  /**
   * @return the technologies
   */
  public Set<Technology> getTechnologies() {
    return technologies;
  }

  /**
   * @param technologies the technologies to set
   */
  public void setTechnologies(Set<Technology> technologies) {
    this.technologies = technologies;
  }

  /**
   * @return the methods
   */
  public Set<Method> getMethods() {
    return methods;
  }

  /**
   * @param methods the methods to set
   */
  public void setMethods(Set<Method> methods) {
    this.methods = methods;
  }

  /**
   * @return the goodies
   */
  public Set<Goodie> getGoodies() {
    return goodies;
  }

  /**
   * @param goodies the goodies to set
   */
  public void setGoodies(Set<Goodie> goodies) {
    this.goodies = goodies;
  }
}
