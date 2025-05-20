package com.example.qcscmis.repository;

import com.example.qcscmis.model.Quantaa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantaaRepository extends JpaRepository<Quantaa, Long> {
    @Query(value = "SELECT * FROM quantaa WHERE LOWER(name) like LOWER(CONCAT('%', :key, '%'))", nativeQuery = true)
    List<Quantaa> getQuantaaList(@Param(value = "key") String key);
}
