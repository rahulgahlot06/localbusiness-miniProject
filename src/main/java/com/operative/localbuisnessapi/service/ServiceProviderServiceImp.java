package com.operative.localbuisnessapi.service;

import com.operative.localbuisnessapi.model.ServiceProvider;
import com.operative.localbuisnessapi.model.Services;
import com.operative.localbuisnessapi.repository.ServiceProviderRepository;
import com.operative.localbuisnessapi.repository.ServicesRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderServiceImp implements ServiceProviderService {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @Autowired
    ServicesRepositry servicesRepositry;

    @Override
    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public boolean spIsPresent(ServiceProvider serviceProvider) {
        List<ServiceProvider> isServiceProv = serviceProviderRepository.findByEmail(serviceProvider.getEmail());
        if (isServiceProv.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean checkServiceProvider(ServiceProvider serviceProvider) {
        List<ServiceProvider> serviceProvTemp = serviceProviderRepository.findByEmailAndPassword(serviceProvider.getEmail(), serviceProvider.getPassword());
        if (serviceProvTemp.isEmpty()) return false;
        return true;
    }

    @Override
    public List<ServiceProvider> showServiceProviders(){
//        System.out.println(serviceProviderRepository.findAll());
        return serviceProviderRepository.findAll();
    }



}
