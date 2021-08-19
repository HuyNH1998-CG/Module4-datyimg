package Big.repository;

import Big.model.comments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<comments, Long> {

}
