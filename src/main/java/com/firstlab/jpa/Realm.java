package com.firstlab.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Realms")
public class Realm {
    @Id
    private String id;

    @Indexed(name = "tittle",unique = true)
    @Field(value = "tittle")
    private String tittle;

    @Indexed(name = "description",unique = false)
    @Field(value = "description")
    private String description;

    public Realm(String tittle) {
        this.tittle = tittle;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Realm(String tittle, String description) {
        this.tittle = tittle;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Realm{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private final String tittle;
        private String description = "Не указан";

        public Builder(String tittle) {
            this.tittle = tittle;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public Realm build() {
            return new Realm(this);
        }
    }

    private Realm(Builder builder) {
        tittle = builder.tittle;
        description = builder.description;
    }

    public Realm() {
    }
}
