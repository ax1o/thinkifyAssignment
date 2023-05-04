package com.assignment.demo.Controller;


import com.assignment.demo.Model.Property;
import com.assignment.demo.Model.User;
import com.assignment.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestParam String name , @RequestParam String phone){

        User user;
        try{
            user = userService.addUser(name,phone);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }

        return new ResponseEntity(user,HttpStatus.CREATED);


    }

    @PostMapping("/addProperty")
    public ResponseEntity addProperty(@RequestBody Property property){

        String mesg = "";

        try{
            mesg = userService.addProperty(property);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }

        return new ResponseEntity(mesg,HttpStatus.CREATED);

    }

    @GetMapping("/searchByPriceRange")
    public ResponseEntity searchByPriceRange(@RequestParam String lowerLimit , @RequestParam String upperLimit){

        List<Property> properties =  userService.searchByPriceRange(lowerLimit,upperLimit);

        return new ResponseEntity(properties,HttpStatus.OK);

    }

//    @PostMapping("/bookProperty")
//    public ResponseEntity bookProperty(@RequestParam String id,@RequestParam  String name , @RequestParam String phone){
//
//        userService.bookProperty(id,name,phone);
//
//    }


}
