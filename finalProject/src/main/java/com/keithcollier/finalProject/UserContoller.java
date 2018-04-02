package com.keithcollier.finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//New UserController
@RestController
@RequestMapping("/api/user")
public class UserContoller {

	private UserRepo userRepo;
	
	@Autowired
	public UserContoller(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	 
	
	//adds a user method
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public User addUser(@RequestBody User newUser) {
		return userRepo.save(newUser);
	}
	
	//get user by id method
	@RequestMapping(value="/{id}")
	public User getUserById(@PathVariable Long id) {
		return userRepo.findOne(id);
		}

	//gets all users method
	@RequestMapping(value="/")
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	//updates user method
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public User updateUserById(@PathVariable Long id, @RequestBody User updateUser) {
		User user = userRepo.findOne(id);
		user.setFirstName(updateUser.getFirstName());
		user.setLastName(updateUser.getLastName());
		user.setUserName(updateUser.getUserName());
		user.setPassword(updateUser.getPassword());
		return userRepo.save(user);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteUserById(@PathVariable long id) {
		userRepo.delete(id);
	}
	
}
