package com.example.demo.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoservice {
	
	private static List<ToDo> todos = new ArrayList<>();
	
	private static int todoCount = 0;
	
	static {
		todos.add(new ToDo(++todoCount, "Paul","Learn AWS1",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++todoCount, "Paul","Learn DevOps1",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++todoCount, "Paul","Learn Full Stack Develop01..",LocalDate.now().plusYears(1),false));
	}
	
	public List<ToDo> findByUsername(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todoCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}


}
