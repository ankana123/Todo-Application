package com.todo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Todo;
import com.todo.exception.IdNotFoundException;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Iterable<Todo> displayAllTodo() {
		return todoRepository.findAll();
	}

	@Override
	public Todo displayById(Integer id) {
		if(todoRepository.findById(id).isPresent()) {
			return todoRepository.findById(id).get();
		}
		else {
			throw new IdNotFoundException("Todo","Id",id);
		}
	}

	@Override
	public Todo updateTodo(Todo todo) {
		Optional<Todo> result=todoRepository.findById(todo.getId());
		Todo existing=result.get();
		existing.setTodoItem(todo.getTodoItem());
		existing.setStatus(todo.getStatus());
		return todoRepository.save(existing);
		
	}

	@Override
	public void deleteTodobyId(Integer id) {
		if(todoRepository.findById(id).isPresent()) {
			todoRepository.deleteById(id);
		}
		else {
			throw new IdNotFoundException("Todo","Id",id);
		}
	}

	@Override
	public void deleteTodo() {
		todoRepository.deleteAll();
	}

}
