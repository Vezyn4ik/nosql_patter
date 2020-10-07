package com.firstlab.repository;

import com.firstlab.SingletonLog;
import com.firstlab.jpa.Firm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public class FirmRepositoryImpl implements FirmRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Boolean update(String name, String description) {
        SingletonLog.getInstance().addAction("User update collection 'Firm', all documents where field 'name' is "
                + name + " and set field 'description' in " + description);
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("description", description);

        return mongoTemplate.updateMulti(query, update, Firm.class).wasAcknowledged();

    }
}
