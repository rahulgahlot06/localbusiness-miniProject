package com.operative.localbuisnessapi.repository;

import com.operative.localbuisnessapi.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Integer> {

    List<ServiceProvider> findByEmail(String email);

    List<ServiceProvider> findByEmailAndPassword(String email, String password);

      List<ServiceProvider> findByServicesServiceName(String serviceName) ;
}
