package com.library.demo.service.impl;
import com.library.demo.entity.Reader;
import com.library.demo.repository.ReaderRepository;
import com.library.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    
    @Autowired
    private ReaderRepository readerRepository;
    
    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
    
    @Override
    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }
    
    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }
    
    @Override
    public Reader updateReader(Long id, Reader reader) {
        Reader existingReader = readerRepository.findById(id).orElse(null);
        if (existingReader != null) {
            existingReader.setName(reader.getName());
            existingReader.setEmail(reader.getEmail());
            existingReader.setPhone(reader.getPhone());
            existingReader.setAddress(reader.getAddress());
            return readerRepository.save(existingReader);
        }
        return null;
    }
    
    @Override
    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}