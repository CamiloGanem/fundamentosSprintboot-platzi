package com.fundamentosplatzi.fundamentosspringboot.fundamentos.repository;

import com.fundamentosplatzi.fundamentosspringboot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
