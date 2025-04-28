package com.dsi.projet.services;

import com.dsi.projet.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll();
    Optional<Comment> findById(Long id);
    Comment save(Comment comment);
    void deleteById(Long id);
}