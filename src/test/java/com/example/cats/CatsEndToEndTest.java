package com.example.cats;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cats.Model.Cat;
import com.example.cats.Repository.CatRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CatsEndToEndTest {

    @Autowired CatRepository catRepo;

    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
        catRepo.deleteAll();
    }

    @Test
    public void testGetById() throws Exception {
        Cat cat = new Cat();
        cat.setName("Boots");

        Cat savedCat = catRepo.save(cat);

        ResponseEntity<Cat> foundCat = testRestTemplate.getForEntity("/api/cats/" + savedCat.getId(), Cat.class);

        assertEquals(HttpStatus.OK, foundCat.getStatusCode());

        assertNotNull(foundCat);
        assertEquals(foundCat.getBody().getName(), "Boots");

    }

    @Test
    public void testGetByIdNotFound() throws Exception {

        ResponseEntity<Cat> foundCat = testRestTemplate.getForEntity("/api/cats/1", Cat.class);

        assertEquals(foundCat.getStatusCode(), HttpStatus.NOT_FOUND);

    }

}
