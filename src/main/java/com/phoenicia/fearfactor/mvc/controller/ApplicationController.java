package com.phoenicia.fearfactor.mvc.controller;

import com.phoenicia.fearfactor.entity.Country;
import com.phoenicia.fearfactor.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Noel
 */
@Controller
public class ApplicationController {
    
    @Autowired
    private CountryRepository repository;
    
    @RequestMapping("/fearfactor")
    public String home(Model model) {
        List<Country> list = (List<Country>) repository.findAll();
        model.addAttribute("countries", list);
        return "home";
    }
}
