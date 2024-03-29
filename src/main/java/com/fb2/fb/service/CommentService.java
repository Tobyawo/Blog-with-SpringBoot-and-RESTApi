package com.fb2.fb.service;

import com.fb2.fb.model.Comment;
import com.fb2.fb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment comment1) {
        comment1.setCreatedAt(getDate());
        commentRepository.save(comment1);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.getCommentById(commentId);
    }

    public void editComment(Comment comment, String comment1) {
        comment.setComment(comment1);
        commentRepository.save(comment);
    }

    public void delete(long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Boolean checkExistence(Long postId){
        if(commentRepository.existsById(postId)){
            return true;
        }
        return false;
    }


    public String getDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern("hh:mm a | dd-MMM"));
    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    public List<Comment> findAll(Long id) {
        return commentRepository.findAllByPostId(id);
    }
}
