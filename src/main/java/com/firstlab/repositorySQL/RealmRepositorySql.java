package com.firstlab.repositorySQL;


import com.firstlab.jpa.sql.RealmSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RealmRepositorySql extends JpaRepository<RealmSql, Long> {

    @Query(value = "select * from Realm_Sql r", nativeQuery = true)
    List<RealmSql> findAll();


}