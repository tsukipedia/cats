package com.example.cats.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cats.Model.Cat;
import com.example.cats.Service.CatService;

@RestController
public class CatsController {

    private CatService catService;

    public CatsController (CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/api/cat/{id}")
    public Cat getCatById(@PathVariable long id) throws Exception {
        return catService.findById(id);
    }
}
