package com.davi.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.workshopmongo.domain.User;
import com.davi.workshopmongo.dto.UserDTO;
import com.davi.workshopmongo.repository.UserRepository;
import com.davi.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll(){
		return ur.findAll();
	}
	
	public User findById(String id) {
		try {
			return ur.findById(id).get();
		}
		catch(RuntimeException e) {
			throw new ObjectNotFoundException("Object not exists.");
		}
	}
	
	public User insert(User obj) {
		return ur.insert(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		ur.deleteById(id);
	}
	
	public User update(UserDTO obj, String id) {
		User user = findById(id);
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		return ur.save(user);
	}
}
