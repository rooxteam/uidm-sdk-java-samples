package com.example.uidmdemo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offices")
public class PolicyEvaluationController {

    /*

    UIDM has a configured politic on "/offices GET"
    Any authentication user can invoke it.
     */
    @GetMapping(produces = "text/plain")
    @PreAuthorize("isAuthenticated() && @uidmAuthz.isAllowed('/offices','GET')")
    public String allowedsample() {
        return "i'm allowed";
    }

    @PostMapping(produces = "text/plain")
    @PreAuthorize("isAuthenticated() && @uidmAuthz.isAllowed('/offices','POST')")
    public String disallowedsample() {
        return "you will never get me, because POST is prohibited";
    }
}
