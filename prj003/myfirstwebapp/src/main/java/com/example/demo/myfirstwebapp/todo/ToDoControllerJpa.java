package com.example.demo.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
	
	private ToDoRepository todoRepository;
	
	
	public ToDoControllerJpa(ToDoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}



	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<ToDo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		
		return "listToDos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDo(ModelMap model) {
		String username = getLoggedInUsername(model);
		ToDo todo= new ToDo(0,"username","Default Desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(ModelMap model, @ModelAttribute("todo") ToDo todo ,@Valid ToDo validToDo, BindingResult result) {
		
			if(result.hasErrors()) {
				System.out.println(result.getFieldError("description"));
				System.out.println(result.getModel());
				System.out.println(result.getFieldError());
				model.put("Error", result.getFieldError());
				return "todo";
			}
		
		  String username = getLoggedInUsername(model);
		  validToDo.setUsername(username);
		  todoRepository.save(validToDo);
		  //todoService.addTodo(username,validToDo.getDescription(), validToDo.getTargetDate(), validToDo.isDone());
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		todoRepository.deleteById(id);
		//todoService.deleteById(id);
		return "redirect:list-todos";
		
	}

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		//ToDo todo = todoService.findById(id);
		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		//todoService.updateTodo(todo);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
