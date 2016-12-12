package bltn.uc3m.tiw.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bltn.uc3m.tiw.domains.User;
import bltn.uc3m.tiw.domains.UserDAO;

@RestController
@CrossOrigin
public class ClientController {
	
	@Autowired
	UserDAO userDao;
	
	@RequestMapping("/users")
	public List<User> allUsers() {
		List<User> users = userDao.findAll();
		return users;
	}
	
	@RequestMapping("/user/new")
	public User registerUser(@RequestBody Map<String, String[]> formParams) {
		// Get new user details 
		String email = formParams.get("email")[0];
		String password = formParams.get("password")[0];
		String forename = formParams.get("forename")[0];
		String surname = formParams.get("surname")[0];
		String city = formParams.get("city")[0];
		
		// Make sure email and/or password aren't taken 
		User userWithEmail = userDao.findByEmail(email);
		User userWithPassword = userDao.findByPassword(password);
		if (userWithEmail == null && userWithPassword == null) {
			
			// Try to save new user 
			User newUser = new User(email, password, forename, surname, city);
			try {
				User savedUser = userDao.save(newUser);
				return savedUser;
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@RequestMapping("/{email}/authenticateLogin")
	public User authenticateLogin(@PathVariable("email") String email, @RequestBody String password) {
		User user = userDao.findByEmailAndPassword(email, password);
		return user;
	}
	
	@RequestMapping("/user/{id}")
	public User userById(@PathVariable("id") Integer id) {
		User user = userDao.findByUserID(id);
		return user;
	}
	
	@RequestMapping("/user/{id}/update")
	public User updateUser(@PathVariable("id") Integer id, @RequestBody Map<String, String[]> formParams) {
		// Get new user details 
		String email = formParams.get("email")[0];
		String forename = formParams.get("forename")[0];
		String surname = formParams.get("surname")[0];
		String city = formParams.get("city")[0];
		
		// Perform updates 
		User user = userDao.findByUserID(id);
		user.setEmail(email);
		user.setForename(forename);
		user.setSurname(surname);
		user.setCity(city);
		
		// Save changes 
		try {
			User updatedUser = userDao.save(user);
			return updatedUser;
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/user/{id}/delete")
	public void deleteUser(@PathVariable("id") Integer id) {
		userDao.delete(id);
	}
}