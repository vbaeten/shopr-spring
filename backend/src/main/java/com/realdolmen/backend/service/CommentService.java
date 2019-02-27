package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Comment;
import com.realdolmen.backend.repository.CommentRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment findById(Long id) throws NotFoundException {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment not found"));
    }

    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Optional<Comment> update(Long id, Comment newComment) {
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()) {
            comment.get().setDescription(newComment.getDescription());
        }
        return comment;
    }
}
