package com.example.itjobs.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    private Filter filter;

    @Column(name = "email")
    private String email;

    @Column(name = "last_notified_on")
    private LocalDateTime lastNotifiedOn;

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
     * @return the filter
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lastNotifiedOn
     */
    public LocalDateTime getLastNotifiedOn() {
        return lastNotifiedOn;
    }

    /**
     * @param lastNotifiedOn the lastNotifiedOn to set
     */
    public void setLastNotifiedOn(LocalDateTime lastNotifiedOn) {
        this.lastNotifiedOn = lastNotifiedOn;
    }
}
