package id.ac.usd.skripsigarin.controller;

import id.ac.usd.skripsigarin.smart.Smart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class DSSController {

    @Autowired
    Smart smart;

    @GetMapping
    public void get(){
        smart.calculate();
    }

}
