package com.example.itjobs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "jobrequirement")
public class JobRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requirement_description")
    private String requirementDescription;

    @ManyToOne
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @ManyToMany
    @JoinTable(name = "requirementlanguage", joinColumns = @JoinColumn(name = "requirement_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languages = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "requirementcertificate", joinColumns = @JoinColumn(name = "requirement_id"), inverseJoinColumns = @JoinColumn(name = "certificate_id"))
    private Set<Certificate> certificates = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "requirementprofession", joinColumns = @JoinColumn(name = "requirement_id"), inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> professions = new HashSet<>();

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
     * @return the requirementDescription
     */
    public String getRequirementDescription() {
        return requirementDescription;
    }

    /**
     * @param requirementDescription the requirementDescription to set
     */
    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
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
     * @return the languages
     */
    public Set<Language> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    /**
     * @return the certificates
     */
    public Set<Certificate> getCertificates() {
        return certificates;
    }

    /**
     * @param certificates the certificates to set
     */
    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }

    /**
     * @return the professions
     */
    public Set<Profession> getProfessions() {
        return professions;
    }

    /**
     * @param professions the professions to set
     */
    public void setProfessions(Set<Profession> professions) {
        this.professions = professions;
    }
}
