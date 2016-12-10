package bltn.uc3m.tiw.domains;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {

	public List<User> findAll();
	public User findByEmailAndPassword(String email, String password);
}
