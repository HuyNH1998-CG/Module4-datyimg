package Big.service;

import Big.model.comments;
import Big.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<comments> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<comments> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(comments comments) {
        commentRepository.save(comments);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void like(Long id) {
        Optional<comments> comments = commentRepository.findById(id);
        comments.get().setLikes(comments.get().getLikes() + 1);
        commentRepository.save(comments.get());
    }

    @Override
    public Page<comments> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }
}
