package org.example.mylibrarybe.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "readers")
@Data
public class Reader {
    @Id
    private String idReader;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private boolean isActive;
    private List<String> borrowedBookIds = new ArrayList<>();
}
