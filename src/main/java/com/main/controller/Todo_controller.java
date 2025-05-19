package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.Entity.Todo_list;
import com.main.services.Todo_services;

@RestController
@RequestMapping("TODO")
@CrossOrigin(origins = "http://localhost:4200")
public class Todo_controller {
	
	@Autowired 
	Todo_services serv;
	
	@PostMapping("/save")
	public Todo_list addtask(@RequestBody Todo_list t)

	{
		return serv.addtask(t);
	}
	
	@PostMapping("/saveall")
	public String saveall(@RequestBody List<Todo_list> tlist)
	{
		return serv.saveall(tlist);
	}
	
	@GetMapping("/findbyid")
	public Todo_list findbyid(@RequestParam int id) {
		return serv.findbyid(id);
	}
	
	@GetMapping("/findall")
	public List<Todo_list> findall() {
		return serv.findall();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,String>>
	deletetask(@PathVariable("id") int id)
	{
		// create json response for fronted
		 serv.deletebyid(id);
		 
		 
		 Map<String,String> response = new HashMap<>();
		 return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updatetask")
	public String updatetask(@RequestParam int id,@RequestBody Todo_list newtodo) {
		return serv.updatebyid(id,newtodo);
	}
	
	
	

}
