package com.fexco.testhello.controller;

import com.fexco.testhello.model.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cgriffin on 27/01/16.
 */
@RestController
public class HelloController {

    AtomicInteger idNum = new AtomicInteger();

    @RequestMapping("/")
    public Model greeting(@RequestParam(defaultValue = "Hello Fexco!") String message ) {
        return new Model(idNum.getAndIncrement(),message);
    }

}
