package com.example.cats.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cats.Model.Cat;
import com.example.cats.Service.CatService;

@RestController
public class CatsController {

    private CatService catService;

    public CatsController (CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/api/cats/{id}")
    public Cat getCatById(@PathVariable String id) throws Exception {
        return catService.findById(id);
    }

    @PostMapping("/api/cats")
    public Cat addCat(@RequestBody Cat cat) {
        return catService.createNewCat(cat);
    }
}
