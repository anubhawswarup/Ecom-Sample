package com.ecom.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.model.Product;
import com.ecom.service.EcomService;

@Controller
@RequestMapping("sample")
public class EcomController {
	@Autowired
	private EcomService ecomService;

	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public CompletableFuture<ResponseEntity<String>> getBook(@PathVariable int id) {
		return CompletableFuture.completedFuture(new ResponseEntity<String>(ecomService.get(id), HttpStatus.OK));
	}
	
	@RequestMapping(value = "/addProduct", consumes = "application/json", method = RequestMethod.PUT)
	public CompletableFuture<ResponseEntity<Void>> addProduct(@RequestBody Product product) {
		return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.OK));
	}

	@RequestMapping(value = "/addAccount", consumes = "application/json", method = RequestMethod.PUT)
	public CompletableFuture<ResponseEntity<Void>> addAccount(@RequestBody Product product) {
		return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.OK));
	}

	@RequestMapping(value = "/addOrder", consumes = "application/json", method = RequestMethod.PUT)
	public CompletableFuture<ResponseEntity<Void>> addOrder(@RequestBody Product product) {
		return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.OK));
	}

}
