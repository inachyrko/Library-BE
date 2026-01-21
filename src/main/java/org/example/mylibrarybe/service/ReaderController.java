package org.example.mylibrarybe.service;

import org.example.mylibrarybe.dao.ReaderRepository;
import org.example.mylibrarybe.model.Reader;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@CrossOrigin(origins = "http://localhost:8081")
public class ReaderController {

    private final ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader add(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}