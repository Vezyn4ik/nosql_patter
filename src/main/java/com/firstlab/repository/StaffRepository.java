package com.firstlab.repository;

import com.firstlab.jpa.Staff;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StaffRepository extends MongoRepository<Staff, ObjectId> {
    Optional<Staff> findByName(String name);
}
