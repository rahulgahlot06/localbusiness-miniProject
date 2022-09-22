package com.operative.localbuisnessapi.service;


import com.operative.localbuisnessapi.model.User;
import com.operative.localbuisnessapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }


    @Override
    public boolean userIsPresent(User user) {
        List<User> isUser = userRepository.findByEmail(user.getEmail());

        if (isUser.isEmpty()) {
            return false;
        }
        return true;
    }



    @Override
    public boolean checkUser(User user) {
        List<User> checkUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(checkUser.isEmpty()){
            return false;
        }
        return true;
    }
}
