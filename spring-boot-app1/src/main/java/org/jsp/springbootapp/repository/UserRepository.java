package org.jsp.springbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhone(long phone);

}
