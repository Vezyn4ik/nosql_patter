package com.firstlab.aggregation;

import com.firstlab.jpa.Firm;
import org.springframework.data.annotation.Id;

public class StaffAggOcupation {

    private Integer salary;

    @Id
    private String occupation;

    private Integer count;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public StaffAggOcupation(String occupation, Integer count) {
        this.occupation = occupation;
        this.count = count;
    }

    @Override
    public String toString() {
        String res="StaffAggOcupation{occupation='" + occupation;
        if(salary!=null){
            res+=", salary=" + salary ;
        }
        if(count!=null){
            res+=", count=" + count ;
        }
        res+="}";
        return res;
    }
}
