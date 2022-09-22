package com.operative.localbuisnessapi.controller;

import com.operative.localbuisnessapi.model.ServiceProvider;
import com.operative.localbuisnessapi.model.Services;
import com.operative.localbuisnessapi.repository.ServiceProviderRepository;
import com.operative.localbuisnessapi.repository.ServicesRepositry;
import com.operative.localbuisnessapi.service.ServiceProviderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")



public class ServiceProviderController {


    @Autowired
    ServiceProviderServiceImp serviceProviderService;


    @Autowired
    ServicesRepositry servicesRepositry;

    @Autowired
    ServiceProviderRepository serviceProviderRepository;


    @PostMapping("/serviceProviders")
    public ResponseEntity<ServiceProvider> addServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        try {
            if (!serviceProviderService.checkServiceProvider(serviceProvider)) {

                List<Services> services = new ArrayList<>();
                serviceProvider.setServices(services);

                ServiceProvider serviceProviderTemp = serviceProviderService.addServiceProvider(serviceProvider);
                return new ResponseEntity<>(serviceProviderTemp, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(serviceProvider, HttpStatus.FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/serviceProviders/signin")
    public boolean checkServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        if (serviceProviderService.checkServiceProvider(serviceProvider)) {
            return true;
        }
        return false;
    }

    @PutMapping("/addServices/{email}")
    public ResponseEntity<ServiceProvider> putServiceProvider(@PathVariable String email, @RequestBody ServiceProvider sp) {
        List<ServiceProvider> spTemp = serviceProviderRepository.findByEmail(email);
        if (!spTemp.isEmpty()) {
            ServiceProvider serviceProvider = spTemp.get(0);
            serviceProvider.setServices(sp.getServices());
            System.out.println(serviceProvider);
            return new ResponseEntity<>(serviceProviderRepository.save(serviceProvider), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{serviceName}")
    public List<ServiceProvider> getServiceProviders(@PathVariable("serviceName") String serviceName) {
        List<ServiceProvider> temp = serviceProviderRepository.findByServicesServiceName(serviceName);
        return temp;
    }

    @GetMapping("/serviceProviders/{email}")
    public ResponseEntity<ServiceProvider> getSerProByEmail(@PathVariable("email") String email){
        List<ServiceProvider> spData =serviceProviderRepository.findByEmail(email);
        if(!spData.isEmpty()){
            return new ResponseEntity<>(spData.get(0),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/serviceProviders")
    public List<ServiceProvider> showUser() {
        return serviceProviderService.showServiceProviders();
    }



}
