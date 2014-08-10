package com.phoenicia.fearfactor.repository;

import com.phoenicia.fearfactor.entity.Continent;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Noel
 */
public interface ContinentRepository extends CrudRepository<Continent, Long>, CustomContinentRepository{
    
}
