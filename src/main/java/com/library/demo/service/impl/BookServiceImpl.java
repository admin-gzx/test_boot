package com.library.demo.service.impl;

import com.library.demo.entity.Book;
import com.library.demo.repository.BookRepository;
import com.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublishDate(book.getPublishDate());
            return bookRepository.save(existingBook);
        }
        return null;
    }
    
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}