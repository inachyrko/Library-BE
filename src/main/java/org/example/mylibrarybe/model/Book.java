package org.example.mylibrarybe.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private int year;
    private String description;
    private String type; // adults | children
}
