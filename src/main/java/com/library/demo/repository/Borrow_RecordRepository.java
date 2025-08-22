package com.library.demo.repository;

import com.library.demo.entity.Borrow_Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Borrow_RecordRepository extends JpaRepository<Borrow_Record, Long> {
    
}
