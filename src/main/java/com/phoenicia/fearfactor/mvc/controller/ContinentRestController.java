package com.phoenicia.fearfactor.mvc.controller;

import com.phoenicia.fearfactor.entity.Continent;
import com.phoenicia.fearfactor.repository.ContinentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Noel
 */
@RestController
@RequestMapping("/api/continent")
public class ContinentRestController {
    
    @Autowired
    private ContinentRepository continentRepo;
    
        
    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<Continent> getContinents() {
        return continentRepo.getContinentTotalFearFactor();
    }
}
