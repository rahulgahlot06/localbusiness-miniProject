package com.operative.localbuisnessapi.service;

import com.operative.localbuisnessapi.model.User;

public interface UserService {


    public User addUser(User user);
    public boolean userIsPresent(User user);

    public boolean checkUser(User user);

}


