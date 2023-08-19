package com.example.itjobs.entity;

import javax.persistence.*;

@Entity
@Table(name = "method")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name")
    private String methodName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MethodCategory methodCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodCategory getCategory() {
        return methodCategory;
    }

    public void setCategory(MethodCategory category) {
        this.methodCategory = category;
    }
}
