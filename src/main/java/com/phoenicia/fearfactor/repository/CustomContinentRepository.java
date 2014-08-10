package com.phoenicia.fearfactor.repository;

import com.phoenicia.fearfactor.entity.Continent;
import java.util.List;

/**
 *
 * @author Noel
 */
public interface CustomContinentRepository {
    public List<Continent> getContinentTotalFearFactor();
}
