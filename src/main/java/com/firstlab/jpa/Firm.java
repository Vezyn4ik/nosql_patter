package com.firstlab.jpa;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Firms")
public class Firm {

    @Id
    private String id;
    @Indexed(unique=true)
    @Field(value = "name")
    private String name;

    @Field(value = "address")
    private String address;

    @Field(value = "identification number")
    private Long in;

    @Field(value = "contactNumber")
    private String contactNumber;

    @Field(value = "manager")
    private String manager;

    @Field(value = "year")
    private Integer year;

    public Firm() {
    }

    public Firm(String name, Long in, String manager) {
        this.name = name;
        this.in = in;
        this.manager = manager;
    }

    public Firm(String name, String contactNumber, String manager) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.manager = manager;
    }

    public Firm(String name, String address, String contactNumber, String manager, Integer year) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.manager = manager;
        this.year = year;
    }

    public Firm(String name, String address, Long in, String contactNumber, String manager, Integer year) {
        this.name = name;
        this.address = address;
        this.in = in;
        this.contactNumber = contactNumber;
        this.manager = manager;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", in=" + in +
                ", contactNumber='" + contactNumber + '\'' +
                ", manager='" + manager + '\'' +
                ", year=" + year +
                '}';
    }

    public static class Builder {
        private final String name;
        private String address = "Не указан";
        private final Long in;
        private String contactNumber = "Не указан";
        private final String manager;

        public Builder(String name, Long in, String manager) {
            this.name = name;
            this.in = in;
            this.manager = manager;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Firm build() {
            return new Firm(this);
        }
    }

    private Firm(Builder builder) {
        name = builder.name;
        address = builder.address;
        in = builder.in;
        contactNumber = builder.contactNumber;
        manager = builder.manager;
    }
}