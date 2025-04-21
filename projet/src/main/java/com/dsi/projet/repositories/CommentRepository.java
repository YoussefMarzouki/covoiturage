package com.dsi.projet.repositories;

import com.dsi.projet.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Additional query methods can be defined here
}