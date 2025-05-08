package com.rosan.Task.Management.and.Collaboration.data.repositories;

import com.rosan.Task.Management.and.Collaboration.data.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
}
