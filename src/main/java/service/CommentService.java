package service;

import model.comments;
import repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<comments> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public comments findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(comments comments) {
        commentRepository.save(comments);
    }

    @Override
    public void remove(int id) {
        commentRepository.remove(id);
    }

    @Override
    public void like(int id) {
        commentRepository.like(id);
    }
}
