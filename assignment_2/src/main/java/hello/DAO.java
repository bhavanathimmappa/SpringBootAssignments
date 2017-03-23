package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DAO extends CrudRepository<Greeting, Integer> {

}
