package com.firstlab.aggregation;

import com.firstlab.jpa.Firm;
import org.springframework.data.annotation.Id;

public class StaffAgg {
    @Id
    private Firm id;
    private Integer money;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Firm getId() {
        return id;
    }

    public void setId(Firm id) {
        this.id = id;
    }

    public StaffAgg(Firm id, Integer money) {
        this.id = id;
        this.money = money;
    }

    @Override
    public String toString() {
        return "StaffAgg{" +
                "id=" + id.getName() +
                ", money=" + money +
                '}';
    }
}
