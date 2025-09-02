package org.example.unicode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unicode")
public class UnicodeController {

    @GetMapping("{id}")
    public String unicodeToChar(@PathVariable int id){
        char c = (char) id;
        return "unicode: " + id + " char: " + c;
    }

    @GetMapping("{ch}/char")
    public String charToUnicode(@PathVariable char ch){
        return "char: " + ch + " unicode: " + String.format("\\u%04x", (int) ch);
    }
}
