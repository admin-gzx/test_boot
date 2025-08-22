package com.library.demo.service.impl;

import com.library.demo.entity.Borrow_Record;
import com.library.demo.repository.Borrow_RecordRepository;
import com.library.demo.service.Borrow_RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Borrow_RecordServiceimpl implements Borrow_RecordService {

    @Autowired
    private Borrow_RecordRepository borrow_recordRepository;

    @Override
    public List<Borrow_Record> getAllBorrow_Records() {
        return borrow_recordRepository.findAll();
    }

    @Override
    public Borrow_Record getBorrow_RecordById(Long id) {
        return borrow_recordRepository.findById(id).orElse(null);
    }
    @Override
    public Borrow_Record createBorrow_Record(Borrow_Record borrow_record) {
        return borrow_recordRepository.save(borrow_record);
    }
    @Override
    public Borrow_Record updateBorrow_Record(Long id, Borrow_Record borrow_record) {
        if (borrow_recordRepository.existsById(id)) {
// 根据错误提示，Borrow_Record 类没有 setId 方法。
// 这里假设需要从数据库获取原对象并更新

            return borrow_recordRepository.save(borrow_record);
        }
        return null;
    }

    @Override
    public void deleteBorrow_Record(Long id) {
        borrow_recordRepository.deleteById(id);
    }

   



}
