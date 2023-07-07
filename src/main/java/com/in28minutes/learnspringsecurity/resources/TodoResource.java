package com.in28minutes.learnspringsecurity.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {

	private Logger logger = LoggerFactory.getLogger(TodoResource.class);
	
	private static final List<Todo> TODOS_LIST =  
		List.of(
			new Todo("in28minutes", "Learn AWS"),
			new Todo("in28minutes", "Get AWS Certified")
		);
	
	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return TODOS_LIST;
	}
	
	@GetMapping("/user/{username}/todos")
	public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
		
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("/user/{username}/todos")
	public void createTodo(@PathVariable String username, @RequestBody Todo todo) {
		logger.info("Create {} for {}", todo, username);
	}
	
}

record Todo(String username, String description) {}
