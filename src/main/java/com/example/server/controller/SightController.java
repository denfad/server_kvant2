package com.example.server.controller;

import com.example.server.model.Sight;
import com.example.server.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path="/sight")
public class SightController {

    private final SightRepository sightRepository;

    @Autowired
    public SightController(SightRepository sightRepository) {
        this.sightRepository = sightRepository;
    }

    @GetMapping(path="/", produces = "application/json")
    public List<Sight> getSights(){
        return sightRepository.listSight();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public Sight getSight(@PathVariable(name="id") Long id){
        return sightRepository.getSightById(id);
    }

    @PutMapping(path="/", consumes = "application/json")
    public void addSight(@RequestBody Sight s){
        sightRepository.addSight(s);
    }

    @PostMapping(path="/", consumes = "application/json",produces = "application/json")
    public Sight updateSight(@RequestBody Sight s){
        return sightRepository.updateSight(s);
    }

    @DeleteMapping(path="/{id}")
    public void deleteSight(@PathVariable Long id){
        sightRepository.delete(id);
    }

}
