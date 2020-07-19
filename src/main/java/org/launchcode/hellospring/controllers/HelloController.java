package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {

    public static String languages(String language) {
        HashMap<String, String> greetings = new HashMap<>();
        greetings.put("spanish", "hola");
        greetings.put("french", "bonjour");
        greetings.put("english", "hello");

        return greetings.get(language);
    }

    // Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    // lives at /hello/goodbye because of the controller level mapping of "hello" in line 8
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "goodbye, Spring!";
    }

    // create handler for requests of form hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public static String createMessage(@RequestParam String name, @RequestParam String language, Model model) {
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of form /hello/launchcode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Max");
        names.add("Bill");
        model.addAttribute("names",names);
        return "hello-list";
    }



}
