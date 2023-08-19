package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "technology_name")
    private String technologyName;

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
     * @return the technologyName
     */
    public String getTechnologyName() {
        return technologyName;
    }

    /**
     * @param technologyName the technologyName to set
     */
    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
}