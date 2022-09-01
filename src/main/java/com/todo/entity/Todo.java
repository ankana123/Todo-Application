package com.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String todoItem;
	private String status;
	
	public Todo(String todoItem, String status) {
		super();
		this.todoItem = todoItem;
		this.status = status;
	}
	
	

}
