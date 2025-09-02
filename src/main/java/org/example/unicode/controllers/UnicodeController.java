package org.example.unicode.controllers;

import lombok.AllArgsConstructor;
import org.example.unicode.repositories.UnicodeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/unicode")
public class UnicodeController {
    private final UnicodeRepository unicodeRepository;

    @GetMapping("{id}")
    public String unicodeToChar(@PathVariable int id){
        var unicode = unicodeRepository.findByUnicode(id).orElse(null);
        if(unicode == null)
            return "No such unicode";

        return "unicode: " + unicode.getUnicode() + " char: " + unicode.getCharacter();
    }

    @GetMapping("{ch}/char")
    public String charToUnicode(@PathVariable char ch){
        var unicode = unicodeRepository.findByCharacter(ch).orElse(null);
        if(unicode == null)
            return "No such char";

        return "char: " + unicode.getCharacter() + " unicode: " + unicode.getUnicode();
    }
}
