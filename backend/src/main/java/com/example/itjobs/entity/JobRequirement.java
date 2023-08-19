package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "jobrequirement")
public class JobRequirement {

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevel experienceLevel;

    @Column(name = "requirement_description")
    private String requirementDescription;
}
