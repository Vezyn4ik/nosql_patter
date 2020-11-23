package com.firstlab.repository;

import com.firstlab.aggregation.StaffAgg;
import com.firstlab.aggregation.StaffAggOcupation;
import com.firstlab.jpa.Staff;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends MongoRepository<Staff, ObjectId>{
    Optional<Staff> findByName(String name);

    @Aggregation("{ $group: { _id : $firm, money  : {$avg : $salary}  } }")
    List<StaffAgg> avgSalaryFirm();

    @Aggregation("{ $group: { _id : null, money  : {$avg : $salary}  } }")
    Integer avgSalary();

    @Aggregation("{ $group: { _id : $firm, money  : {$max : $salary}  } }")
    List<StaffAgg> maxSalaryFirm();

    @Aggregation("{ $group: {_id : $occupation, count  : {$sum : 1}  } }")
    List<StaffAggOcupation> countOccupation();

    @Aggregation("{$group: {_id : $occupation, salary: {$avg : $salary}}}")
    List<StaffAggOcupation> OccupationSalary();
}
