package org.jsp.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dto.Product;
import org.jsp.springbootapp.dto.Product;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.repository.ProductRepository;
import org.jsp.springbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.representer.Represent;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/{mid}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product ,@PathVariable (name="mid") int mid) {
	  return productService.saveProduct(product, mid);

	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		 return productService.updateProduct(product);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> findById(@PathVariable(name = "id") int id) {
		 return productService.findById(id);
	}

	@GetMapping("/findbybrand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable(name = "brand") String brand) {
		 return productService.findByBrand(brand);
	}

	@GetMapping("/findbycategory/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable(name = "category") String category) {
		 return productService.findByCategory(category);
	}
}
