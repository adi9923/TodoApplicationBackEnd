package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.Entity.Todo_list;

@Repository
public interface Todo_repository extends JpaRepository<Todo_list, Integer>{

}
