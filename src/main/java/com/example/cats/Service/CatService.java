package com.example.cats.Service;

import org.springframework.stereotype.Service;

import com.example.cats.Commons.CatNotFoundException;
import com.example.cats.Model.Cat;
import com.example.cats.Repository.CatRepository;

import java.util.Optional;

@Service
public class CatService {

    private CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat findById(long id) throws CatNotFoundException {

        Optional<Cat> oCat = catRepository.findById(id);

        if (oCat.isEmpty()) {
            throw new CatNotFoundException();
        }
        return oCat.get();
    }
}
