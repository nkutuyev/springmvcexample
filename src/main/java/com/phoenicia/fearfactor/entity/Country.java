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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer population;
    @Column(nullable = false)
    private Integer gdp;
    @Column(nullable = false)
    private Integer aggression;
    
    @ManyToOne(optional = false, targetEntity = Continent.class)
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;

    protected Country() { }

    public Country(String name, Integer population, Integer gdp, Integer aggression, Continent continent) {
        this.name = name;
        this.population = population;
        this.gdp = gdp;
        this.aggression = aggression;
        this.continent = continent;
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Integer getAggression() {
        return aggression;
    }

    public void setAggression(Integer aggression) {
        this.aggression = aggression;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
    
    public Integer getFearFactor(){
        int factor = (gdp/1000 + population/100) * aggression;
        return factor;
    }
   
}
