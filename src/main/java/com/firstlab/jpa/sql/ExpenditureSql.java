package com.firstlab.jpa.sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Firm;
import com.firstlab.jpa.Realm;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;


@Entity
public class ExpenditureSql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tittle",nullable = false,unique = true)
    private String tittle;
    @Column(name = "money",nullable = false)
    private Integer money;
    @Column(name = "description",nullable = true)
    private String description;

  @ManyToOne
    @JsonIgnore
    @JoinColumn(name="firm_id", nullable=false)
    private FirmSql firmSql;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="realm_id", nullable=false)
    private RealmSql realmSql;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public FirmSql getFirmSql() {
        return firmSql;
    }

    public void setFirmSql(FirmSql firmSql) {
        this.firmSql = firmSql;
    }

    public RealmSql getRealmSql() {
        return realmSql;
    }

    public void setRealmSql(RealmSql realmSql) {
        this.realmSql = realmSql;
    }

    @Override
    public String toString() {
        return "ExpenditureSql{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", money=" + money +
                ", firmSql=" + firmSql +
                ", realmSql=" + realmSql +
                '}';
    }

    public static class Builder {
        private final String tittle;
        private final Integer money;
        private FirmSql firmSql;
        private RealmSql realmSql;

        public Builder(String tittle, Integer money) {
            this.tittle = tittle;
            this.money = money;
        }

        public ExpenditureSql.Builder firm(FirmSql firmSql) {
            this.firmSql = firmSql;
            return this;
        }

        public ExpenditureSql.Builder realm(RealmSql realmSql) {
            this.realmSql = realmSql;
            return this;
        }

        public ExpenditureSql build() {
            return new ExpenditureSql(this);
        }
    }

    private ExpenditureSql(ExpenditureSql.Builder builder) {
        tittle = builder.tittle;
        money = builder.money;
        firmSql = builder.firmSql;
        realmSql = builder.realmSql;

    }

    public ExpenditureSql() {
    }

    public ExpenditureSql(String tittle, Integer money, String description, FirmSql firmSql, RealmSql realmSql) {
        this.tittle = tittle;
        this.money = money;
        this.description = description;
        this.firmSql = firmSql;
        this.realmSql = realmSql;
    }
}
