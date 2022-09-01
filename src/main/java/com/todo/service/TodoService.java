package com.todo.service;

import com.todo.entity.Todo;

public interface TodoService {
	
	Todo saveTodo(Todo todo);//insert

	Iterable<Todo> displayAllTodo();//displayAll
	
	Todo displayById(Integer id);//displaybyId
	
	Todo updateTodo(Todo todo); // update by ID
	
	void deleteTodobyId(Integer id);// deletebyId
	
	void deleteTodo();//deleteAll
	
	

}
