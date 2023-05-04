package com.assignment.demo.Model;

public class Property {

    User user;
    String type;

    String houseAddress;

    String location;
    String noOfRooms;

    String price;

    String securityDeposit;

    String dealType;

    public Property(){

    }

    public Property(User user, String type, String houseAddress, String location, String noOfRooms, String price, String securityDeposit, String dealType) {
        this.user = user;
        this.type = type;
        this.houseAddress = houseAddress;
        this.location = location;
        this.noOfRooms = noOfRooms;
        this.price = price;
        this.securityDeposit = securityDeposit;
        this.dealType = dealType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(String securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }
}
