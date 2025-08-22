package com.library.demo.controller;

import com.library.demo.entity.Reader;
import com.library.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@CrossOrigin(origins = "*")
public class ReaderController {
    
    @Autowired
    private ReaderService readerService;
    
    @GetMapping("")
    public List<Reader> getAllReaders() {
        return readerService.getAllReaders();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable Long id) {
        Reader reader = readerService.getReaderById(id);
        if (reader != null) {
            return ResponseEntity.ok(reader);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public Reader createReader(@RequestBody Reader reader) {
        return readerService.createReader(reader);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable Long id, @RequestBody Reader reader) {
        Reader updatedReader = readerService.updateReader(id, reader);
        if (updatedReader != null) {
            return ResponseEntity.ok(updatedReader);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return ResponseEntity.noContent().build();
    }
}