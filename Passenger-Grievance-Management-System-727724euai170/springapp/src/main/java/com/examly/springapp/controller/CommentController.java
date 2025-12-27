package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Comment;
import com.examly.springapp.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping
    public ResponseEntity<Comment> add(@RequestBody Comment c) {
        return new ResponseEntity<>(service.addComment(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> all() {
        return new ResponseEntity<>(service.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> get(@PathVariable Long id) {
        Comment c = service.getCommentById(id);
        if (c == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment c) {
        Comment updated = service.updateComment(id, c);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
