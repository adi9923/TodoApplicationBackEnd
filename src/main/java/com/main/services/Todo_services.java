package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entity.Todo_list;
import com.main.repository.Todo_repository;

import jakarta.transaction.Transactional;

@Service
public class Todo_services {
	@Autowired
	Todo_repository repo;
	
	@Transactional
	public Todo_list addtask(Todo_list t)
	{
		
		return repo.save(t);
	}
	
	public String saveall(List<Todo_list> Tlist)
	{
		repo.saveAll(Tlist);
		return "All Data Added Successfully";
		
	}
	
	public Todo_list findbyid(int id)
	{
		return repo.findById(id).orElse(null);
	}
	
	
	public String deletebyid(int id)
	{
		repo.deleteById(id);
		return "Deleted Successfully";
	}
	
	public List<Todo_list> findall()
	{
		return repo.findAll();
	}


	public String updatebyid(int id, Todo_list todo)
	
	{
		Todo_list existingtodo=repo.findById(id).orElse(null);
		if(existingtodo != null) {
		if(todo!=null)
		{
			if(todo.getTitle()!=null)
			{
				existingtodo.setTitle(todo.getTitle());
			}
			if(todo.getStatus()!=null)
			{
				existingtodo.setStatus(todo.getStatus());
			}
			repo.save(existingtodo);
			return "Record Updated Successfully";
		}
		return "No data to update";
		}
		return "records not found";
	}

}
