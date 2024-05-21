package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	
    @Autowired
    private TodoRepository todoRepository;
	
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/contact")
    public String todo(@ModelAttribute Todo todo) {
        return "contact";
        
    }
    
    @PostMapping("/complete")
    public String createTodo(@ModelAttribute @Validated Todo todo, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "contact"; // Return back to the form if there are validation errors
        }
        
    	todoRepository.save(todo);
        return "/complete";
    }
}
