package org.example.mylibrarybe.dao;

import org.example.mylibrarybe.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByType(String typeP);
}
