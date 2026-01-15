package org.example.mylibrarybe.service;

import org.example.mylibrarybe.dao.BookRepository;
import org.example.mylibrarybe.model.Book;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String type) {
        return type == null ? repository.findAll() : repository.findByType(type);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        repository.deleteById(id);
    }
}
