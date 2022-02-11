package com.example.uidmdemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rooxteam.uidm.sdk.spring.authorization.AalResourceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PostAuthorizeSampleController {


    @Autowired
    AalResourceValidation uidmAuthz;

    ObjectMapper objectMapper = new ObjectMapper();
    /*

  UIDM has a configured politic on "/offices GET"
  Any authentication user can invoke it.
   */
    @GetMapping(produces = "application/json")
    @PreAuthorize("isAuthenticated() && @uidmAuthz.isAllowed('/persons','GET')")
    @ResponseBody
    public ResponseEntity<String> personList() throws JsonProcessingException {
        List<Person> ret = new ArrayList<>();
        ret.add(new Person("123","Test 123",1));
        ret.add(new Person("456","Test 456",2));
        ret.add(new Person("789","Test 789",1));

        String response = objectMapper.writeValueAsString(ret);
        return new ResponseEntity<>(uidmAuthz.postprocess("/persons", "GET", Collections.emptyMap(), response), HttpStatus.OK);
    }




}
