package com.rosan.Task.Management.and.Collaboration.data.repositories;

import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositroy extends JpaRepository<Project,String> {
}
