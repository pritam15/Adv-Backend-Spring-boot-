package com.todoList.todoListAPIs.Model;

import lombok.Data;
@EnableFeignClients
@Data
public class Todo {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}