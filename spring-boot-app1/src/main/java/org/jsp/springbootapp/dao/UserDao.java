package org.jsp.springbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.User;
import org.jsp.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> findByPhone(long phone) {
		return userRepository.findByPhone(phone);
	}

}
