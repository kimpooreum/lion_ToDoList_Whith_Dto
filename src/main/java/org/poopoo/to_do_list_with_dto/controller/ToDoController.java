package org.poopoo.to_do_list_with_dto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @GetMapping
    public String list() {
        return "todo-list";
    }
}
