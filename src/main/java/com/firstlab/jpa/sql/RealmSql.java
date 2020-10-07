package com.firstlab.jpa.sql;



import com.firstlab.jpa.Realm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RealmSql",
        indexes = {@Index(name = "index_tittle",  columnList="tittle", unique = true),
                @Index(name = "index_description", columnList="description",     unique = false)})
public class RealmSql {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tittle",nullable = false)
    private String tittle;

    @Column(name = "description",nullable = true)
    private String description;

    @OneToMany(mappedBy="realmSql")
    private List<ExpenditureSql> expenditureSql;
    public RealmSql() {
    }

    @Override
    public String toString() {
        return "RealmSql{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExpenditureSql> getExpenditureSql() {
        return expenditureSql;
    }

    public void setExpenditureSql(List<ExpenditureSql> expenditureSql) {
        this.expenditureSql = expenditureSql;
    }
    public static class Builder {
        private final String tittle;
        private String description = "Не указан";

        public Builder(String tittle) {
            this.tittle = tittle;
        }

        public RealmSql.Builder description(String description) {
            this.description = description;
            return this;
        }


        public RealmSql build() {
            return new RealmSql(this);
        }
    }

    private RealmSql(RealmSql.Builder builder) {
        tittle = builder.tittle;
        description = builder.description;
    }

    public RealmSql(String tittle) {
        this.tittle = tittle;
    }
}
