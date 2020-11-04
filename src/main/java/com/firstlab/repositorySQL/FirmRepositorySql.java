package com.firstlab.repositorySQL;

import com.firstlab.jpa.Firm;
import com.firstlab.jpa.sql.FirmSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FirmRepositorySql extends JpaRepository<FirmSql, Long> {


    Optional<FirmSql> findByName(String name);

    @Query(value = "select * from Firm_Sql f", nativeQuery = true)
    List<FirmSql> findAll();

    @Transactional
    @Modifying
    @Query(value = "update Firm_Sql f set f.manager =?1 where f.id = ?2",
            nativeQuery = true)
    void updateFirmSetManagerForId(String manager,  Long id);
}
