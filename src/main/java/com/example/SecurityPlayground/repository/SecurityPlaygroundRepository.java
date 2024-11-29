package com.example.SecurityPlayground.repository;

import com.example.SecurityPlayground.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface SecurityPlaygroundRepository extends CrudRepository<User, Long> {
    List<User> findByGithubUsername(String githubUsername);
}
