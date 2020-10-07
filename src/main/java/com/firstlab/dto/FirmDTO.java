package com.firstlab.dto;


public class FirmDTO {
    private String name;
    private String address;
    private String contactNumber;
    private String manager;
    private Integer age;

    public FirmDTO() {
    }

    public FirmDTO(String name, String address, String contactNumber, String manager, Integer age) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.manager = manager;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FirmDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", manager='" + manager + '\'' +
                ", age=" + age +
                '}';
    }
}
