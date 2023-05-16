package com.rungroup.web2.repository;

import com.rungroup.web2.model.school;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<school, Long> {

    Optional<school> findByschooltitle(String url);
    school findById(long user_id);
}
