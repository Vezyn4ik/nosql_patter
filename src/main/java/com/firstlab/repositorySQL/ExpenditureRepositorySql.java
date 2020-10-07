package com.firstlab.repositorySQL;

import com.firstlab.jpa.sql.ExpenditureSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ExpenditureRepositorySql extends JpaRepository<ExpenditureSql, Long> {

    @Query(value = "select * from Expenditure_Sql e", nativeQuery = true)
    List<ExpenditureSql> findAll();

    @Transactional
    void deleteByTittle(String tittle);

    @Query(value = "select * from Expenditure_Sql e order by money", nativeQuery = true)
    List<ExpenditureSql> findAllByOrderByMoney();

    @Query(value = "select * from Expenditure_Sql e where e.tittle=:tittle", nativeQuery = true)
    List<ExpenditureSql> findAllByTittle(@Param("tittle") String tittle);
}
