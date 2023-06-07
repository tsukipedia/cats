package com.example.cats.Repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.cats.Model.Cat;

public class CatRepositoryCustomImpl implements CatRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CatRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<Cat> findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Cat cat = mongoTemplate.findOne(query, Cat.class);
        return Optional.ofNullable(cat);
    }

}
