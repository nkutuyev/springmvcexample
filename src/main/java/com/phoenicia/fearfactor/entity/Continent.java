package com.phoenicia.fearfactor.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Noel
 */
@Entity
@Table(name = "continent")
public class Continent implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String name;
    
    @Transient
    private Integer totalFearFactor;

    public Integer getTotalFearFactor() {
        return totalFearFactor;
    }

    public void setTotalFearFactor(Integer totalFearFactor) {
        this.totalFearFactor = totalFearFactor;
    }
    
    protected Continent() { }

    public Continent(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
}
