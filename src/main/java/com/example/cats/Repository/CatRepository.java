package com.example.cats.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cats.Model.Cat;

public interface CatRepository extends MongoRepository<Cat, String>, CatRepositoryCustom {
}
