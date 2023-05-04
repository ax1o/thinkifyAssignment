package com.assignment.demo.Service;


import com.assignment.demo.Model.Property;
import com.assignment.demo.Model.User;
import com.assignment.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User addUser(String name,String phone){

        User user ;

        try{
           user = userRepository.addUser(name,phone);
       }catch(Exception e){
            throw new RuntimeException("User Does Not Exists Hence Property Can't be added");
       }

        return user;

    }

    public String addProperty(Property property){

        try{
            userRepository.addProperty(property);
        }catch (Exception e){
            throw new RuntimeException("User Does Not Exists Hence Property Can't be added");
        }


        return "Property Added successfully";

    }

    public List<Property> searchByPriceRange(String lowerLimit, String upperLimit){

        return userRepository.searchByPriceRange(lowerLimit,upperLimit);

    }

    public void bookProperty(String id, String name , String phone){

        userRepository.bookProperty(id,name,phone);

    }




}
