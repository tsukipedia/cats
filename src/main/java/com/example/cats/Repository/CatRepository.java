package com.example.cats.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cats.Model.Cat;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
