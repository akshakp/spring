package com.akshak.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshak.product.model.Product;
import com.akshak.product.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductServiceController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product getProduct(@PathVariable("id") Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Product save(@RequestBody Product product) {
		return productRepository.save(product);
	}
}