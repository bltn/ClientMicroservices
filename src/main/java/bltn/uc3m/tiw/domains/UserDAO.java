package bltn.uc3m.tiw.domains;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {

	public List<User> findAll();
	public User findByEmailAndPassword(String email, String password);
	public User findByUserID(Integer userID);
	public User findByEmail(String email);
	public User findByPassword(String password);
	public void delete(Integer userID);
	public <S extends User> S save(User user);
}
