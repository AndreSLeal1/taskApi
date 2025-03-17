package com.exiti.taskmanager.controller;

import com.exiti.taskmanager.domain.User;
import com.exiti.taskmanager.service.HelloWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//
@RestController
@RequestMapping("/hello-word")
public class HelloWordController {
    @Autowired
    private HelloWordService helloWordService;

    @GetMapping
    public String helloWord() {
        return helloWordService.helloWord("Kipper");
    }

    @PostMapping("/{id}")
    public String helloWordPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter,  @RequestBody User body) {
        return "Hello World " + body.getName() + id;
    }

}
