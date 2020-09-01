package com.example.alm02jacobswilhelmhhugol;

import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("fortune")
public class Controller {

    Translator translator;

    @CrossOrigin
    @GetMapping()
    public Fortune getFortune(@RequestParam String name,@RequestParam String nationality,@RequestParam int age) throws FileNotFoundException {
    Translator getTheNr = new Translator();

        return new Fortune(getTheNr.getFortuneFromList(name,nationality,age));
    }



}
