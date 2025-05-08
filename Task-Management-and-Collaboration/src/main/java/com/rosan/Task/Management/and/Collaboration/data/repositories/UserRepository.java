package com.rosan.Task.Management.and.Collaboration.data.repositories;

import com.rosan.Task.Management.and.Collaboration.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
