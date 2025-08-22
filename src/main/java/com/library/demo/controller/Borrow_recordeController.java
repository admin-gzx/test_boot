package com.library.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.library.demo.entity.Borrow_Record;
import com.library.demo.service.Borrow_RecordService;
import java.util.List;

@RestController
@RequestMapping("/api/borrow_records")
@CrossOrigin(origins = "*")
public class Borrow_recordeController {
    @Autowired
    private Borrow_RecordService borrow_RecordService;
    @GetMapping
    public List<Borrow_Record> getAllBorrow_Records() {
        return borrow_RecordService.getAllBorrow_Records();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Borrow_Record> getBorrow_RecordById(@PathVariable Long id) {
        Borrow_Record borrow_Record = borrow_RecordService.getBorrow_RecordById(id);
        if (borrow_Record != null) {
            return ResponseEntity.ok(borrow_Record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Borrow_Record> createBorrow_Record(@RequestBody Borrow_Record borrow_record) {
        Borrow_Record createdBorrow_Record = borrow_RecordService.createBorrow_Record(borrow_record);
        return ResponseEntity.ok(createdBorrow_Record);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Borrow_Record> updateBorrow_Record(@PathVariable Long id, @RequestBody Borrow_Record borrow_record) {
        Borrow_Record updatedBorrow_Record = borrow_RecordService.updateBorrow_Record(id, borrow_record);
        if (updatedBorrow_Record != null) {
            return ResponseEntity.ok(updatedBorrow_Record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow_Record(@PathVariable Long id) {
        borrow_RecordService.deleteBorrow_Record(id);
        return ResponseEntity.ok().build();
    }



}
