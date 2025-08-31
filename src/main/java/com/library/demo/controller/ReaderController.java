package com.library.demo.controller;

import com.library.demo.entity.Reader;
import com.library.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@CrossOrigin(origins = "*")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

     //获取所有读者列表
    @GetMapping("")
    public List<Reader> getAllReader(){
        return readerService.getAllReaders();
    }


    //根据id查询读者信息
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable Long id){
        Reader reader=readerService.getReaderById(id);
        if(reader!=null){
            return ResponseEntity.ok(reader);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //添加读者
    @PostMapping("")
    public Reader createReader(@RequestBody Reader reader){
        return readerService.createReader(reader);
    }

    //根据id删除读者
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaderById(@PathVariable Long id){
        readerService.deleteReader(id);
        return ResponseEntity.ok().build();
    }



    //根据id更新读者信息
    @PutMapping("/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable Long id, @RequestBody Reader reader){
        Reader updateReader=readerService.updateReader(id, reader);
        if(updateReader!=null){
            return ResponseEntity.ok(updateReader);
        }
        else {
            return ResponseEntity.notFound().build();
        }


    }
}
