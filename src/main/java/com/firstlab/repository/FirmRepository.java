package com.firstlab.repository;

import com.firstlab.jpa.Firm;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FirmRepository extends MongoRepository<Firm, ObjectId>, FirmRepositoryCustom {
    Firm findFirstByName(String name);

    List<Firm> findAllByManager(String manager);

    void deleteFirmByInLessThan(Long in);

}
