package com.operative.localbuisnessapi.model;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
    @Table(name = "services")
    public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long serviceId;
    private String serviceName;


        public Long getServiceId() {
            return serviceId;
        }

        public void setServiceId(Long serviceId) {
            this.serviceId = serviceId;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }






    public Services(Long serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }
    public Services(){}



}
