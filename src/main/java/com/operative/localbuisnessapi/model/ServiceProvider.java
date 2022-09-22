package com.operative.localbuisnessapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_providers")
public class ServiceProvider {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "serviceprov_id")
    private Long serviceprov_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String phonenumber;
    @Column(name = "email")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password")
    private String password;



  @Column(name = "serviceprov_id")
    public Long getServiceprov_id() {
        return serviceprov_id;
    }

    public void setServiceprov_id(Long serviceprov_id) {
        this.serviceprov_id = serviceprov_id;
    }




    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public ServiceProvider(String name, String phonenumber, String email, String password,List<Services> services) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.services = services;
    }

    public ServiceProvider() {
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_spID", referencedColumnName = "serviceprov_id")
    private List<Services> services;



}
