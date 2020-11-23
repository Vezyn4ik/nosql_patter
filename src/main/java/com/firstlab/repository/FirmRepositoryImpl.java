package com.firstlab.repository;

import com.firstlab.SingletonLog;
import com.firstlab.aggregation.FirmAg;
import com.firstlab.jpa.Firm;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


public class FirmRepositoryImpl implements FirmRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<FirmAg> countFirmsYear() {
        GroupOperation groupByYear = group("year").count().as("countFirmYear");
        SortOperation sortByYearDesc = sort(Sort.Direction.DESC, "countFirmYear");
        Aggregation aggregation = newAggregation(
                groupByYear, sortByYearDesc);
        return mongoTemplate.aggregate(aggregation, "Firms", FirmAg.class).getMappedResults();
    }

    @Override
    public List<FirmAg> maxFirmsYear() {
        GroupOperation groupByYear = group("year").count().as("countFirmYear");
        GroupOperation groupMax = group().max("countFirmYear").as("maxFirmsYear");
        Aggregation aggregation = newAggregation(
                groupByYear,groupMax);
        return mongoTemplate.aggregate(aggregation, "Firms", FirmAg.class).getMappedResults();
    }

    @Override
    public Boolean update(String name, String description) {
        //  SingletonLog.getInstance().addAction("User update collection 'Firm', all documents where field 'name' is "
        //          + name + " and set field 'description' in " + description);
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("description", description);

        return mongoTemplate.updateMulti(query, update, Firm.class).wasAcknowledged();

    }

    @Override
    public Boolean update(Firm firm) {
        Query query = new Query(Criteria.where("id").is(firm.getId()));
        Update update = new Update();
        update.set("name", firm.getName());
        update.set("address", firm.getAddress());
        update.set("identification", firm.getIn());
        update.set("contactNumber", firm.getContactNumber());
        update.set("manager", firm.getManager());
        update.set("year", firm.getYear());
        return mongoTemplate.updateMulti(query, update, Firm.class).wasAcknowledged();

    }


    @Override
    public Firm checkSave(Firm firm) throws Exception {
        mongoTemplate.setWriteConcern(WriteConcern.JOURNALED);
        int retries = 3;
        while (retries > 0) {
            try {
                SingletonLog.getInstance().addAction("User insert to collection 'Firm' document " + firm.getName());
                return mongoTemplate.insert(firm, "firms");

            } catch (Exception e) {
                retries--;
                Thread.sleep(1000);
            }
        }
        System.out.println("Error to insert document");
        return null;
    }


}
