package com.ram.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.springboot.entity.User;

@Repository
public interface UserProfileRepository extends JpaRepository<User, Long> {

}
