package com.library.demo.service;

import com.library.demo.entity.Reader;

import java.util.List;

public interface ReaderService {
    List<Reader> getAllReaders();
    Reader getReaderById(Long id);
    Reader createReader(Reader reader);
    Reader updateReader(Long id, Reader reader);
    void deleteReader(Long id);
}