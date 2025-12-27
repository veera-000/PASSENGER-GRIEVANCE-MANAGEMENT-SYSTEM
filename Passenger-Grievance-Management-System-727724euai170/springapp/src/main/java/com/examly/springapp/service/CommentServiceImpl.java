package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Comment;
import com.examly.springapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repo;

    public Comment addComment(Comment comment) {
        return repo.save(comment);
    }

    public List<Comment> getAllComments() {
        return repo.findAll();
    }

    public Comment getCommentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Comment updateComment(Long id, Comment comment) {
        Comment c = repo.findById(id).orElse(null);
        if (c == null) return null;
        c.setContent(comment.getContent());
        c.setIsInternal(comment.getIsInternal());
        return repo.save(c);
    }
}
