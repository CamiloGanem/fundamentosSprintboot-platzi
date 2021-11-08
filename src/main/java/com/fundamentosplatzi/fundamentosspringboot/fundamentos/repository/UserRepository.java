package com.fundamentosplatzi.fundamentosspringboot.fundamentos.repository;


import com.fundamentosplatzi.fundamentosspringboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
