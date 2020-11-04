package com.firstlab.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "Staff")
public class Staff {
    @Id
    private String id;

    @Indexed(name = "name",unique = true)
    @Field(value = "name")
    private String name;

    @Field(value = "occupation")
    private String occupation;

    @Field(value = "email")
    private String email;

    @Field(value = "phone")
    private Long phone;

    @Field(value = "salary")
    private Integer salary;

    @Field(value = "description")
    private String description;

    @Field(value = "firm")
    private Firm firm;

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Staff(String id, String name, String occupation, String email, Long phone, Integer salary, String description, Firm firm) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.description = description;
        this.firm = firm;
    }

    public Staff() {
    }

    public Staff(String name, String occupation, String email, Long phone, Integer salary, String description, Firm firm) {
        this.name = name;
        this.occupation = occupation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.description = description;
        this.firm = firm;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                ", firm=" + firm +
                '}';
    }
}
