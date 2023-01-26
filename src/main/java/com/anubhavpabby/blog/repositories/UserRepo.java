package com.anubhavpabby.blog.repositories;

import com.anubhavpabby.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
