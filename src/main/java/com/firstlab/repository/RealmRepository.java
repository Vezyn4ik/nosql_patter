package com.firstlab.repository;

import com.firstlab.jpa.Realm;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RealmRepository extends MongoRepository<Realm, ObjectId> {

}
