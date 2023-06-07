package com.example.cats.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="cats")
public class Cat {

    @Id
    private String id;

    private String name;

}
