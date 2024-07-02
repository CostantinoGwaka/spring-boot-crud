package dev.isofttz.calender_app.controller;


import dev.isofttz.calender_app.model.Content;
import dev.isofttz.calender_app.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<Content> findById(@PathVariable("id") Integer id){
    return repository.findById(id);
    }



    //create read update delete pagging sort


}
