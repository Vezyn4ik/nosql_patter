package com.firstlab.aggregation;

import org.springframework.data.annotation.Id;

public class ExpAg {
    @Id
    private String id;
    private Long money;

    public ExpAg(String id, Long money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ExpAg{" +
                "name=" + id +
                ", money=" + money +
                '}';
    }
}
