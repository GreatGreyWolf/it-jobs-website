package com.example.itjobs.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "filter")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "keyword_search")
    private String keywordSearch;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "company_size")
    private String companySize;

    @Column(name = "industry")
    private String industry;

    @Column(name = "location")
    private String location;

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
     * @return the keywordSearch
     */
    public String getKeywordSearch() {
      return keywordSearch;
    }

    /**
     * @param keywordSearch the keywordSearch to set
     */
    public void setKeywordSearch(String keywordSearch) {
      this.keywordSearch = keywordSearch;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
      return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
      this.companyName = companyName;
    }

    /**
     * @return the companyType
     */
    public String getCompanyType() {
      return companyType;
    }

    /**
     * @param companyType the companyType to set
     */
    public void setCompanyType(String companyType) {
      this.companyType = companyType;
    }

    /**
     * @return the companySize
     */
    public String getCompanySize() {
      return companySize;
    }

    /**
     * @param companySize the companySize to set
     */
    public void setCompanySize(String companySize) {
      this.companySize = companySize;
    }

    /**
     * @return the industry
     */
    public String getIndustry() {
      return industry;
    }

    /**
     * @param industry the industry to set
     */
    public void setIndustry(String industry) {
      this.industry = industry;
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
    public BigDecimal getSalaryMin() {
      return salaryMin;
    }

    /**
     * @param salaryMin the salaryMin to set
     */
    public void setSalaryMin(BigDecimal salaryMin) {
      this.salaryMin = salaryMin;
    }

    /**
     * @return the salaryMax
     */
    public BigDecimal getSalaryMax() {
      return salaryMax;
    }

    /**
     * @param salaryMax the salaryMax to set
     */
    public void setSalaryMax(BigDecimal salaryMax) {
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
     * @return the goodie
     */
    public String getGoodie() {
      return goodie;
    }

    /**
     * @param goodie the goodie to set
     */
    public void setGoodie(String goodie) {
      this.goodie = goodie;
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
     * @return the technology
     */
    public Technology getTechnology() {
      return technology;
    }

    /**
     * @param technology the technology to set
     */
    public void setTechnology(Technology technology) {
      this.technology = technology;
    }

    /**
     * @return the method
     */
    public Method getMethod() {
      return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(Method method) {
      this.method = method;
    }

    /**
     * @return the experienceLevel
     */
    public ExperienceLevel getExperienceLevel() {
      return experienceLevel;
    }

    /**
     * @param experienceLevel the experienceLevel to set
     */
    public void setExperienceLevel(ExperienceLevel experienceLevel) {
      this.experienceLevel = experienceLevel;
    }

    /**
     * @return the language
     */
    public Language getLanguage() {
      return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(Language language) {
      this.language = language;
    }

    /**
     * @return the profession
     */
    public Profession getProfession() {
      return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(Profession profession) {
      this.profession = profession;
    }

    /**
     * @return the certificate
     */
    public Certificate getCertificate() {
      return certificate;
    }

    /**
     * @param certificate the certificate to set
     */
    public void setCertificate(Certificate certificate) {
      this.certificate = certificate;
    }

    @Column(name = "salary_min")
    private BigDecimal salaryMin;

    @Column(name = "salary_max")
    private BigDecimal salaryMax;

    @Column(name = "work_percentage_min")
    private Integer workPercentageMin;

    @Column(name = "work_percentage_max")
    private Integer workPercentageMax;

    @Column(name = "goodie")
    private String goodie;

    @ManyToOne
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @ManyToOne
    @JoinColumn(name = "method_id")
    private Method method;

    @ManyToOne
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "certificate_id")
    private Certificate certificate;
}
