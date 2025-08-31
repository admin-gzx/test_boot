package com.library.demo.service.Servicelmpl;

import com.library.demo.entity.Book;
import com.library.demo.repository.BookRepository;
import com.library.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book book1 = bookRepository.getById(id);
        if(book1!=null){
            book1.setAuthor(book.getAuthor());
            book1.setTitle(book.getTitle());
            book1.setPublishDate(book.getPublishDate());
            book1.setIsbn(book.getIsbn());
            return bookRepository.save(book1);

        }
        return null;

    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }
}
