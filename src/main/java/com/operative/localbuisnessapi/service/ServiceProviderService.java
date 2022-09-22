package com.operative.localbuisnessapi.service;

import com.operative.localbuisnessapi.model.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {

    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider);

    public boolean spIsPresent(ServiceProvider serviceProvider);

    public boolean checkServiceProvider(ServiceProvider serviceProvider);

    public List<ServiceProvider> showServiceProviders();
}
