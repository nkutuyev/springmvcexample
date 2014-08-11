/*
 * Copyright 2014 Noel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phoenicia.fearfactor.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Noel
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {
    
    private Long id;
    private String name;
    private Integer population;
    private Integer gdp;
    private Integer aggression;
    private Integer fearFactor;
    
    private Continent continent;

    protected Country() { }

    public Country(String name, Integer population, Integer gdp, Integer aggression, Continent continent) {
        this.name = name;
        this.population = population;
        this.gdp = gdp;
        this.aggression = aggression;
        this.continent = continent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @Column(nullable = false)
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column(nullable = false)
    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    @Column(nullable = false)
    public Integer getAggression() {
        return aggression;
    }

    public void setAggression(Integer aggression) {
        this.aggression = aggression;
    }

    @ManyToOne(optional = false, targetEntity = Continent.class)
    @JoinColumn(name = "continent_id", nullable = false)
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
    
    @Column(nullable = false)
    public Integer getFearFactor(){
        this.fearFactor = (gdp/1000 + population/100) * aggression;
        return this.fearFactor;
    }

    public void setFearFactor(Integer fearFactor) {
        this.fearFactor = fearFactor;
    }
   
}
