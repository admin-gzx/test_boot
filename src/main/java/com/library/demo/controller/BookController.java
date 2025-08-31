package com.library.demo.controller;

import com.library.demo.entity.Book;
import com.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return  bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>  getBookById(@PathVariable Long id) {
        Book book= bookService.getBookById(id);
        if(book!=null){
            return ResponseEntity.ok(book);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = bookService.updateBook(id,book);
        if(book1!=null){
            return ResponseEntity.ok(book1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
