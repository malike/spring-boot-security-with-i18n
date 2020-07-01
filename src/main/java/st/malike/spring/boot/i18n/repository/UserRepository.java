package st.malike.spring.boot.i18n.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import st.malike.spring.boot.i18n.model.User;

import java.io.Serializable;

/**
 * malike_st.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Serializable> {

  public User findByUsername(String username);
}
