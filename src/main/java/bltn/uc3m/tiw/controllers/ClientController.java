package bltn.uc3m.tiw.controllers;

import java.util.List;

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
	
	@RequestMapping("/{email}/authenticateLogin")
	public boolean authenticateLogin(@PathVariable("email") String email, @RequestBody String password) {
		boolean valid = false;
		
		if (userDao.findByEmailAndPassword(email, password) != null) {
			valid = true;
		}
		return valid; 
	}
}