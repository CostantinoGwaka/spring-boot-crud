package dev.isofttz.calender_app.controller;


import dev.isofttz.calender_app.model.Content;
import dev.isofttz.calender_app.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }


    //make a request  and find all  the piece of content in the system
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Content findById(@PathVariable("id") Integer id){
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content){
        repository.createContent(content);
    }

    //create read update delete pagging sort


}
