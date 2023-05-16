package com.rungroup.web2.repository;

import com.rungroup.web2.model.User;
import com.rungroup.web2.model.school;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

}
