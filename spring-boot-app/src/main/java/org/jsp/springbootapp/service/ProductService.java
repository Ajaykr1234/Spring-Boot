package org.jsp.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapp.dao.MerchantDao;
import org.jsp.springbootapp.dao.ProductDao;
import org.jsp.springbootapp.dto.Merchant;
import org.jsp.springbootapp.dto.Product;
import org.jsp.springbootapp.dto.ResponseStructure;
import org.jsp.springbootapp.exception.MerchantNotFoundException;
import org.jsp.springbootapp.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int merchant_id) {
		Optional<Merchant> reMerchant = merchantDao.findById(merchant_id);
		if (reMerchant.isPresent()) {
			Merchant merchant = reMerchant.get();
			product.setMerchant(merchant); // Assiggning mercahnt to product
			merchant.getProducts().add(product);// Assigning product to merchant
			ResponseStructure<Product> structure = new ResponseStructure<>();
			structure.setData(productDao.saveProduct(product));// Adding product
			merchantDao.saveMerchant(merchant); // updating mercahnt
			structure.setMessage("Product save sucessfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return ResponseEntity.status(HttpStatus.CREATED.value()).body(structure);
		}
		throw new MerchantNotFoundException("Can not save product as Merchant Id is Invaild Try Again!");

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productDao.findById(product.getId());
		if (recProduct.isPresent()) {

			Product dbProduct = recProduct.get();
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setCategory(product.getCategory());
			dbProduct.setDescription(product.getDescription());
			dbProduct.setCost(product.getCost());
			structure.setData(productDao.saveProduct(dbProduct));
			structure.setMessage("Product Updated Sucessfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED.value()).body(structure);
		} else {

			throw new ProductNotFoundException("product can not be updated try Again! ");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recproduct = productDao.findById(id);
		if (recproduct.isPresent()) {
			structure.setMessage("Product found ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recproduct.get());
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		} else {
			throw new ProductNotFoundException("Product not found as id is wrong ");
		}
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(String brand) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		List<Product> recproduct = productDao.findByBrand(brand);
		if (recproduct.isEmpty()) {
			throw new ProductNotFoundException("product not found as brand is wrong ");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recproduct);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(String category) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		List<Product> recproduct = productDao.findByCategory(category);
		if (recproduct.isEmpty()) {
			throw new ProductNotFoundException("product not found as category is worng ");
		} else {
			structure.setMessage("Record  Displayed ");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(recproduct);
			return ResponseEntity.status(HttpStatus.OK.value()).body(structure);
		}
	}

}
