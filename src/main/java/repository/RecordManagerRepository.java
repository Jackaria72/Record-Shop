package repository;

import model.RecordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordManagerRepository extends CrudRepository<RecordModel, Long> {
}
