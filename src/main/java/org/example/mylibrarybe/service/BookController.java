package org.example.mylibrarybe.service;

import org.example.mylibrarybe.dao.BookRepository;
import org.example.mylibrarybe.model.Book;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        book.setId(id);
        return repository.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        repository.deleteById(id);
    }
}
