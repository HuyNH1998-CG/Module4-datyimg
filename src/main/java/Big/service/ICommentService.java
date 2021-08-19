package Big.service;

import Big.model.comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICommentService {
    Iterable<comments> findAll();

    Optional<comments> findById(Long id);

    void save(comments comments);

    void remove(Long id);

    void like(Long id);

    Page<comments> findAll(Pageable pageable);
}
