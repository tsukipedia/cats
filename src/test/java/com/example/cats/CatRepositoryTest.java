package com.example.cats;

import com.example.cats.Model.Cat;
import com.example.cats.Repository.CatRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CatRepositoryTest {

    @Autowired
    CatRepository catRepository;

    @Test
    public void testFindByName() {
        Cat cat = new Cat();
        cat.setName("Boots");
        catRepository.save(cat);

        Optional<Cat> optionalCat = catRepository.findByName("Boots");

        assertThat(optionalCat).isNotEmpty();
        optionalCat.ifPresent(c -> assertThat(c.getName()).isEqualTo("Boots"));
    }

    @Test
    public void testFindByNameNotFound() {
        Cat cat = new Cat();
        cat.setName("Boots");
        catRepository.save(cat);

        Optional<Cat> optionalCat = catRepository.findByName("NotExists");

        assertThat(optionalCat).isEmpty();
    }
}

