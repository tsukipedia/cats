package com.example.cats.Repository;

import java.util.Optional;

import com.example.cats.Model.Cat;

public interface CatRepositoryCustom {
    public Optional<Cat> findByName(String name);
}
