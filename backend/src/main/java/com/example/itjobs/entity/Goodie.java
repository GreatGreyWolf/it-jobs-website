package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "goodie")
public class Goodie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goodie_name")
    private String goodieName;

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
     * @return the goodieName
     */
    public String getGoodieName() {
        return goodieName;
    }

    /**
     * @param goodieName the goodieName to set
     */
    public void setGoodieName(String goodieName) {
        this.goodieName = goodieName;
    }
}
