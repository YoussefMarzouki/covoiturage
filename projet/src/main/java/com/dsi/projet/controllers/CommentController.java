package com.dsi.projet.controllers;

import com.dsi.projet.entities.Comment;
import com.dsi.projet.services.CommentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.findById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comment createComment(@Valid @RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isPresent()) {
            Comment updatedComment = comment.get();
            updatedComment.setRating(commentDetails.getRating());
            updatedComment.setContenu(commentDetails.getContenu());
            updatedComment.setDate(commentDetails.getDate());
            return ResponseEntity.ok(commentService.save(updatedComment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}