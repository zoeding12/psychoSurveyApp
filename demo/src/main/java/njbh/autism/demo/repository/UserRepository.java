package njbh.autism.demo.repository;

import org.springframework.data.repository.CrudRepository;
import njbh.autism.demo.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
