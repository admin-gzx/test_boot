package com.library.demo.service;

import com.library.demo.entity.Borrow_Record;

import java.util.List;


public interface Borrow_RecordService {

    List<Borrow_Record> getAllBorrow_Records();
    Borrow_Record getBorrow_RecordById(Long id);
    Borrow_Record createBorrow_Record(Borrow_Record borrow_record);
    Borrow_Record updateBorrow_Record(Long id, Borrow_Record borrow_record);
    void deleteBorrow_Record(Long id);
    
}
