package com.firstlab.jpa.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.List;


@Entity
public class StaffSql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "salary", nullable = true)
    private Integer salary;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="firm_id", nullable=false)
    private FirmSql firmSql;

    public StaffSql(String name, String occupation, String email, Long phone, Integer salary, String description, FirmSql firmSql) {
        this.name = name;
        this.occupation = occupation;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.description = description;
        this.firmSql = firmSql;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public FirmSql getFirmSql() {
        return firmSql;
    }

    public void setFirmSql(FirmSql firmSql) {
        this.firmSql = firmSql;
    }

    @Override
    public String toString() {
        return "StaffSql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                ", firmSql=" + firmSql +
                '}';
    }

    public StaffSql() {
    }
}