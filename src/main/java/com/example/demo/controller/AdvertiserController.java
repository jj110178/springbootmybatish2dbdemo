package com.example.demo.controller;

import com.example.demo.model.Advertiser;
import com.example.demo.repository.AdvertiserMapper;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertiser")
public class AdvertiserController {

  @Autowired
  AdvertiserMapper mapper;

  // create a new Advertiser
  @PostMapping
  public int createNewAdvertiser(@Valid @RequestBody Advertiser advertiser){
    return mapper.insert(advertiser);
  }

  // get a single Advertiser by Id
  @GetMapping("/{id}")
  public Advertiser getAdvertiserById(@PathVariable(value = "id") int id) {
    return mapper.findById(id);
  }

  // Update Advertiser
  @PutMapping
  public int updateAdvertiser(@Valid @RequestBody Advertiser advertiser){
    return mapper.update(advertiser);
  }

  // Delete Advertiser
  @DeleteMapping("/{id}")
  public int deleteAdvertiser(@PathVariable(value = "id") int id) {
    return mapper.deleteById(id);
  }


}
