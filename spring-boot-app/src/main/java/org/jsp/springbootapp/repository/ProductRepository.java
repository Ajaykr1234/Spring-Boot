package org.jsp.springbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String category);

}
