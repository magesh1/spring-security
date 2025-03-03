package com.example.security.repository;

import com.example.security.model.UserDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsModel, Integer> {
    UserDetailsModel findByUserName(String userName);
}
