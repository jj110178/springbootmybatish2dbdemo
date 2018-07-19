package com.example.demo.controller;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.model.Advertiser;
import com.example.demo.repository.AdvertiserMapper;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<Advertiser> getAdvertiserById(@PathVariable(value = "id") int id) {
    Advertiser advertiser = mapper.findById(id);
    if(advertiser == null)
      throw new ResourceNotFoundException(" Advertiser ", " Id ", id );
    return new ResponseEntity<Advertiser>(advertiser, HttpStatus.OK);
  }

  // get a single Advertiser by Id and Validate if Valid to do Transaction
  @GetMapping("/validate/{id}")
  public ResponseEntity<?> getAdvertiserByIdAndValidateEligibility(@PathVariable(value = "id") int id) {
    Advertiser advertiser = mapper.findById(id);
    if(!validateCreditLimit(id)){
      throw new ResourceNotFoundException("Advertiser Not Allowed to transact ", " Id ", id );
    }

    return new ResponseEntity<Advertiser>(advertiser, HttpStatus.OK);
  }

  // Update Advertiser
  @PutMapping("/")
  public int updateAdvertiser(@Valid @RequestBody Advertiser advertiser){
    return mapper.update(advertiser);
  }

  // Delete Advertiser
  @DeleteMapping("/{id}")
  public int  deleteAdvertiser(@PathVariable(value = "id") int id) {
    return mapper.deleteById(id);
  }


  /**
   * Verify and Validate Advertiser
   *
   * @param id
   */
  private boolean validateCreditLimit(int id) {
    Advertiser advertiser = mapper.findById(id);
    if(advertiser != null &&  advertiser.getCreditLimit() > 0){
      return true;
    }
    return false;
  }
}
