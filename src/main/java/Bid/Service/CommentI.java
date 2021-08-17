package Bid.Service;

import Bid.Model.Comment;

import java.util.List;

public interface CommentI {
    List<Comment> getComment();

    Comment save(Comment comment);

    Comment like(int id);

    Comment findByID(int id);

}
