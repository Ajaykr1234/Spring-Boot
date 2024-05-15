package org.jsp.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dao.UserDao;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.dto.User;
import org.jsp.springbootapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User save ");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(userDao.saveUser(user));
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(structure);

	}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();

		Optional<User> reUser = userDao.findById(id);

		if (reUser.isPresent()) {
			structure.setMessage("User Found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(reUser.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new UserNotFoundException("User not found with id " + id);
		}

	}

	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		List<User> reUser = userDao.findByName(name);
		if (reUser.isEmpty()) {
			throw new UserNotFoundException("User not found with name " + name);
		} else {
			structure.setMessage("User Found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(reUser);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<User>> findByEmail(String email) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> reUser = userDao.findByEmail(email);
		if (reUser.isEmpty()) {
			throw new UserNotFoundException("User not found with Email " + email);
		} else {
			structure.setMessage("User Found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(reUser.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<User>> findByPhone(long phone) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> reUser = userDao.findByPhone(phone);
		if (reUser.isEmpty()) {
			throw new UserNotFoundException("User not found with Phone " + phone);
		} else {
			structure.setMessage("User Found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(reUser.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}	}

}
