package com.deepak.springpostgressgradledemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(){
        log.info("HELLO WORLD");
        return "Hello world";
    }}
