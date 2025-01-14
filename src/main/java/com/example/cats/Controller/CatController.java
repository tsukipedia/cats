package com.example.cats.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cats.Model.Cat;
import com.example.cats.Service.CatService;

@RestController
@RequestMapping("/api/v1/cats/")
public class CatController {

    private CatService catService;

    public CatController (CatService catService) {
        this.catService = catService;
    }

    @GetMapping("id/{id}")
    public Cat getCatById(@PathVariable String id) throws Exception {
        return catService.findById(id);
    }

    @GetMapping("name/{name}")
    public Cat getCatByName(@PathVariable String name) throws Exception {
        return catService.findByName(name);
    }

    @PostMapping()
    public Cat addCat(@RequestBody Cat cat) {
        return catService.createNewCat(cat);
    }
}
