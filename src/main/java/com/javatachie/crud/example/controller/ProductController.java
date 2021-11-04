package com.javatachie.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatachie.crud.example.entity.Product;
import com.javatachie.crud.example.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/v1/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@PostMapping("/v1/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return productService.addProducts(products);
	}
	
	@GetMapping("/v1/getAllProducs")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/v1/getPoductById/{id}")
	public Product getproductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/v1/getProductByName/{name}")
	public Product getproductByName(@PathVariable String name) {
		return productService .getProductByName(name);
	}
	
	@PutMapping("/v1/editProduct")
	public Product editProdut(@RequestBody Product product) {
		return productService.editProductById(product);
	}
	
	@DeleteMapping("/v1/deleteProductById/{id}")
	public String deleteProductById(@PathVariable int id) {
		return productService.deleteProductWithId(id);
	}
}
