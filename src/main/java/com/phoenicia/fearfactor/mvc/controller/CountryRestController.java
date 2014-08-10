package com.phoenicia.fearfactor.mvc.controller;

import com.phoenicia.fearfactor.entity.Country;
import com.phoenicia.fearfactor.repository.CountryRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Noel
 */
@RestController
@RequestMapping(value = "api/country")
public class CountryRestController {
    
    private static final Logger LOG = LoggerFactory.getLogger(CountryRestController.class.getName());
    
    @Autowired
    private CountryRepository repository;
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<Country> getAll() {
        List<Country> list = (List<Country>) repository.findAll();
        return list;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Country getCountryById(@PathVariable Long id) {
        return repository.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    public Country createCountry(@RequestBody Country country){
        return repository.save(country);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes="application/json")
    public Country updateCountry(@RequestBody Country country,@PathVariable Long id){
        return repository.save(country);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCountry(@PathVariable Long id){
        repository.delete(id);
    }

}
