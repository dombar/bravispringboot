package br.com.bravi.controller;

import br.com.bravi.service.BalancedService;
import br.com.bravi.TextObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("balanced")
public class BalancedController {

    @Autowired
    private BalancedService braviService;

    @GetMapping(value = "/", produces = "application/json")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public String balanced(@RequestBody TextObject text) {

        if (text == null || (text.getText() == null || text.getText().isEmpty())) {
            return "Text is empty";
        }

        if (text.getText().length() > 99) {
            return "Ops, text is very long";
        }

        return braviService.balanced(text.getText());
    }

}
