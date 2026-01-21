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

    @GetMapping("/{idReader}")
    public Reader getReader(@PathVariable String idReader) {
        return readerRepository.findById(idReader).orElseThrow();
    }

    @PostMapping
    public Reader addReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }

    @PutMapping("/{idReader}")
    public Reader updateReader(@PathVariable String idReader, @RequestBody Reader reader) {
        reader.setIdReader(idReader);
        return readerRepository.save(reader);
    }

    @DeleteMapping("/{idReader}")
    public void deleteReader(@PathVariable String idReader) {
        readerRepository.deleteById(idReader);
    }
}




