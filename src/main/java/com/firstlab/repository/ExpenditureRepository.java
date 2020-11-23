package com.firstlab.repository;

import com.firstlab.aggregation.ExpAg;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Firm;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenditureRepository extends MongoRepository<Expenditure, ObjectId> {
    Expenditure findFirstByTittle(String tittle);

    List<Expenditure> findAllByMoney(Integer money);

    Optional<Expenditure> findByTittle(String tittle);

    @Aggregation("{ $group: { _id : $firm, money  : {$max : $money}  } }")
    List<ExpAg> maxLostMoneyFirm();

    @Aggregation("{ $group: { _id : $firm, money  : {$sum : $money}  } }")
    List<ExpAg> sumLostMoneyFirm();

    @Aggregation("{$match: { 'firm.name':'АВТОМАГИСТРАЛЬ-Север3' }}")
    List<Expenditure> matchFirmName();

    @Aggregation("{$match: { money:{$gt:1000} }},{$Project: {$id:0,$tittle: 1,$money:1}}")
    List<Expenditure> shortExpenditures();

    List<Expenditure> findAllByFirm(Firm firm);
}
