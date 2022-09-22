package com.operative.localbuisnessapi.controller;


import com.operative.localbuisnessapi.model.Services;
import com.operative.localbuisnessapi.repository.ServicesRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serviceslist")
public class ServicesController {

    @Autowired
    private ServicesRepositry servicesRepositry;

    @GetMapping("/Services")
    public List<Services> getServices(){
        return servicesRepositry.findAll();
    }

}
