package com.firstlab.repository;

import com.firstlab.jpa.Expenditure;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenditureRepository extends MongoRepository<Expenditure, ObjectId> {
    Expenditure findFirstByTittle(String tittle);

    List<Expenditure> findAllByMoney(Integer money);

    Optional<Expenditure> findByTittle(String tittle);

}
