package org.example.mylibrarybe.dao;

import org.example.mylibrarybe.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
}