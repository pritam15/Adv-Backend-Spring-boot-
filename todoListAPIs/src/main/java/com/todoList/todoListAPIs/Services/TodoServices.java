package com.todoList.todoListAPIs.Services;
import com.todoList.todoListAPIs.Client.JSONPlaceHolderClient;
import com.todoList.todoListAPIs.Model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class TodoServices {
	@Slf4j
	@Service
	public class TodoService {
	    @Autowired
	    public JSONPlaceHolderClient jsonPlaceHolderClient;
	    public List<Todo> getAllTodos(){
	        log.info("fetching all todo items");
	        return JSONPlaceHolderClient.getAllTodos();
	    }
	    public Todo getSingleTodo(String number){
	        log.info("fetching todo item {}", number);
	        return jsonPlaceHolderClient.getSingleTodo(number);
	    }
	    public Todo createTodo(Todo item){
	        log.info("creating todo item {}", item);
	        return jsonPlaceHolderClient.createTodo(item);
	    }
	}
}
