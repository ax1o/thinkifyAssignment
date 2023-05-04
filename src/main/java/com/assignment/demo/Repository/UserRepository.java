package com.assignment.demo.Repository;

import com.assignment.demo.Model.Property;
import com.assignment.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new LinkedList<>();

    List<Property> properties = new LinkedList<>();

    //List<Booked> bookedList = new LinkedList<>();
    HashMap<User,List<Property>> propertyMap = new HashMap<>();
    public User addUser(String name , String phone){

        //creating new user
        User user = new User(name,phone);

        //check if the user exists or not and if the user exists then throw exception
        for(User user1 : users){

            if(user1.getName().equals(name) && user1.getPhoneNumber().equals(phone)){
                throw new RuntimeException("Error! user already exists");
            }

        }

        //if code reaches here it means the user didn't exist
        users.add(user);

        return user;

    }

    public void addProperty(Property property){

        User user = property.getUser();

        //search if the user exists in the Users list or not
        int flag = 1;
        for(User u : users){

            if(u.getPhoneNumber().equals(user.getPhoneNumber()) && u.getName().equals(user.getName())){
                flag = 0;
                break;
            }

        }

        //user didn't exist
        if(flag == 1){
            throw new RuntimeException("User Does Not Exists Hence Property Can't be added");
        }

        //if user has already listed some flats then add this property to the list
        if(propertyMap.containsKey(user)){

            List<Property> listOfFlats = propertyMap.get(user);

            listOfFlats.add(property);

            propertyMap.put(user,listOfFlats);

        }else{

            List<Property> list = new LinkedList<>();
            list.add(property);
            propertyMap.put(user,list);

        }

        properties.add(property);



    }

    public List<Property> searchByPriceRange(String lowerLimit,String upperLimit){

        int ll = Integer.valueOf(lowerLimit);
        int ul = Integer.valueOf(upperLimit);

        List<Property> propertiesWithinRange = new LinkedList<>();

        for(Property p : properties){

            int price = Integer.valueOf(p.getPrice());

            if( price >= ll && price <= ul)
                propertiesWithinRange.add(p);

        }

        return propertiesWithinRange;



    }

//    public void bookProperty(String id, String name , String phone){
//
//        User user;
//        int flag = 1;
//        //find user with given credentials
//        for(User u : users){
//            //user found
//            if(u.getName().equals(name) && u.getPhoneNumber().equals(phone)){
//                user = u;
//                flag = 0;
//                break;
//            }
//
//        }
//
//        if(flag == 1){
//            throw new RuntimeException("User Not Found");
//        }
//
//        //find property
//        //i have assumed that the index of property is the unique id
//        int i = Integer.valueOf(id);
//
//        if(i >= properties.size()){
//            throw new RuntimeException("Property doesn't exists");
//        }
//
//        Property prop = properties.get(i);
//
//
//
//
//
//    }




}
