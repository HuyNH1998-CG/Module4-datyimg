package service;

import model.comments;

import java.util.List;

public interface ICommentService {
    List<comments> findAll();

    comments findById(int id);

    void save(comments comments);

    void remove(int id);

    void like(int id);
}
