package com.firstlab.jpa.sql;


import com.firstlab.jpa.Firm;

import javax.persistence.*;
import java.util.List;

@Entity
public class FirmSql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false,unique=true)
    private String name;

    @Column(name = "address",nullable = true)
    private String address;
    @Column(name = "contactNumber",nullable = true)
    private String contactNumber;
    @Column(name = "manager",nullable = true)
    private String manager;
    @Column(name = "year",nullable = true)
    private Integer year;
    @Column(name = "indetification_number",nullable = true)
    private Long indetification_number;

    @OneToMany(mappedBy = "firmSql")
    private List<StaffSql> staffSql;

    @OneToMany(mappedBy="firmSql",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenditureSql> expenditureSql;

    public FirmSql() {
    }

    public FirmSql(String name, String address, String contactNumber, String manager, Integer year, Long indetification_number) {

        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.manager = manager;
        this.year = year;
        this.indetification_number = indetification_number;
    }

    public FirmSql(String name, String manager, Long indetification_number) {
        this.name = name;
        this.manager = manager;
        this.indetification_number = indetification_number;
    }

    public FirmSql(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long roleId) {
        this.id = roleId;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getIndetification_number() {
        return indetification_number;
    }

    public void setIndetification_number(Long indetification_number) {
        this.indetification_number = indetification_number;
    }

    public List<ExpenditureSql> getExpenditureSql() {
        return expenditureSql;
    }

    public void setExpenditureSql(List<ExpenditureSql> expenditureSql) {
        this.expenditureSql = expenditureSql;
    }

    @Override
    public String toString() {
        return "FirmSql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", manager='" + manager + '\'' +
                ", year=" + year +
                ", indetification_number=" + indetification_number +
                '}';
    }

    public static class Builder {
        private final String name;
        private String address = "Не указан";
        private final Long indetification_number;
        private String contactNumber = "Не указан";
        private final String manager;

        public Builder(String name, Long indetification_number, String manager) {
            this.name = name;
            this.indetification_number = indetification_number;
            this.manager = manager;
        }

        public FirmSql.Builder address(String address) {
            this.address = address;
            return this;
        }

        public FirmSql.Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public FirmSql build() {
            return new FirmSql(this);
        }
    }

    private FirmSql(FirmSql.Builder builder) {
        name = builder.name;
        address = builder.address;
        indetification_number = builder.indetification_number;
        contactNumber = builder.contactNumber;
        manager = builder.manager;
    }
}
