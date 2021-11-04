package com.javatachie.crud.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatachie.crud.example.entity.Product;
import com.javatachie.crud.example.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//Save Single product to db
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	//Save List of Products to db
	public List<Product> addProducts(List<Product> products){
		return productRepo.saveAll(products);
	}
	//get all products from db
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	//get products by id from db
	public Product getProductById(int id) {
		return productRepo.findById(id).get();
	}
	//get products by name from db
	public Product getProductByName(String name) {
		return productRepo.findByName(name);
	}
	//edit the product
	public Product editProductById(Product product) {
		Product existingProduct = productRepo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepo.save(existingProduct);
	}
	//delete the product by id
	public String deleteProductWithId(int id) {
		productRepo.deleteById(id);
		return "Product with id: "+id+"is deleted successfully";
	}
}
