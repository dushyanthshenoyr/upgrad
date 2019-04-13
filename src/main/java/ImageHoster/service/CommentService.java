package ImageHoster.service;

import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;

import java.util.List;

@Service

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment newComment(Comment comment){
        return commentRepository.newComment(comment);

    }
    public List<Comment> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }

}
