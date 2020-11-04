package com.firstlab.repositorySQL;

import com.firstlab.jpa.sql.StaffSql;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepositorySql extends JpaRepository<StaffSql, Long> {
    Optional<StaffSql> findByName(String name);
}
