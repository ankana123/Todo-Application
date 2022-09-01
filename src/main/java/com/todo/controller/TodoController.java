package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.entity.Todo;
import com.todo.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("todos",todoService.displayAllTodo());
		return "index";
	}
	
	@GetMapping("/add")
	public String addTodo(Model model) {
		model.addAttribute("todo", new Todo());
		return "addTodo";
	}
	
	@PostMapping("/addTodo")
	public String createTodo(Todo todo) {
		todoService.saveTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editTodo(Model model,@PathVariable("id") int id) {
		model.addAttribute("todo",todoService.displayById(id));
		return "editTodo";
	}
	
	@PostMapping("/updateTodo")
	public String updateTodo(Todo todo) {
		todoService.updateTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable("id") int id) {
		todoService.deleteTodobyId(id);
		return "redirect:/";
	}
	
	@GetMapping("/test")
	public String test() {
		Todo t=new Todo();
		t.setId(1);
		t.setTodoItem("cns");
		t.setStatus("yes");
		todoService.saveTodo(t);
		return "f";
	}
	
}
