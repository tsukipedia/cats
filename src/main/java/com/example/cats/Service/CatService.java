package com.example.cats.Service;

import org.springframework.stereotype.Service;

import com.example.cats.Controller.CatNotFoundException;
import com.example.cats.Model.Cat;
import com.example.cats.Repository.CatRepository;

import java.util.Optional;

@Service
public class CatService {

    private CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat findById(String id) throws CatNotFoundException {

        Optional<Cat> oCat = catRepository.findById(id);

        if (oCat.isEmpty()) {
            throw new CatNotFoundException();
        }
        return oCat.get();
    }

    public Cat findByName(String name) throws CatNotFoundException {
        Optional<Cat> oCat = catRepository.findByName(name);

        if (oCat.isEmpty()) {
            throw new CatNotFoundException();
        }
        return oCat.get();
    }

    public Cat createNewCat(Cat cat) {
        return catRepository.save(cat);
    }

}
