package org.jsp.springbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Product;
import org.jsp.springbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	
	public Product updateProduct(Product product) {
		
			return productRepository.save(product);
}


	public Optional<Product> findById( int id) {
		return productRepository.findById(id);
	}


	public List<Product> findByBrand( String brand) {
		return productRepository.findByBrand(brand);
	}

	
	public List<Product> findByCategory( String category) {
		return productRepository.findByCategory(category);
	}

}
