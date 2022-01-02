package com.todoList.todoListAPIs.Controller;
import com.todoList.todoListAPIs.Client.*;
import com.todoList.todoListAPIs.Model.*;
import com.todoList.todoListAPIs.Services.*;
import com.todoList.todoListAPIs.Services.TodoServices.TodoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("todo-list")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @GetMapping("{number}")
    public Todo getSingleTodo(@PathVariable String number){
        return todoService.getSingleTodo(number);
    }
    @PostMapping("")
    public Todo createTodo(@RequestBody Todo item){
        return todoService.createTodo(item);
    }
}