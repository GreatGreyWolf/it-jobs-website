package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "profession")
public class Profession {

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
     * @return the professionName
     */
    public String getProfessionName() {
        return professionName;
    }

    /**
     * @param professionName the professionName to set
     */
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profession_name")
    private String professionName;
}

