package com.firstlab.repository;

import com.firstlab.jpa.Firm;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FirmRepository extends MongoRepository<Firm, ObjectId>, FirmRepositoryCustom {
    Firm findFirstByName(String name);

    List<Firm> findAllByManager(String manager);

    void deleteFirmByInLessThan(Long in);

    Optional<Firm> findByName(String name);

}
