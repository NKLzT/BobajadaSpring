package com.nikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikas.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
