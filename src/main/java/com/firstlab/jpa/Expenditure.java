package com.firstlab.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Expenditures")
public class Expenditure {
    @Id
    private String id;

    @Field(value = "tittle")
    private String tittle;

    @Field(value = "money")
    private Integer money;

    @Field(value = "firm")
    private Firm firm;

    @Field(value = "realm")
    private Realm realm;

    public Expenditure(String tittle, Integer money) {
        this.tittle = tittle;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", money=" + money +
                ", firm=" + firm +
                ", realm=" + realm +
                '}';
    }

    public static class Builder {
        private final String tittle;
        private final Integer money;
        private Firm firm;
        private Realm realm;

        public Builder(String tittle, Integer money) {
            this.tittle = tittle;
            this.money = money;
        }

        public Builder firm(Firm firm) {
            this.firm = firm;
            return this;
        }

        public Builder realm(Realm realm) {
            this.realm = realm;
            return this;
        }

        public Expenditure build() {
            return new Expenditure(this);
        }
    }

    private Expenditure(Builder builder) {
        tittle = builder.tittle;
        money = builder.money;
        firm = builder.firm;
        realm = builder.realm;

    }

    public Expenditure() {
    }
}


