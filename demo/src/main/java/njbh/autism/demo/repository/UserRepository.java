package njbh.autism.demo.repository;

import org.springframework.data.repository.*;
import njbh.autism.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("UserRepository")
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findAllByName(String name);
}
