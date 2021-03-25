package com.cg.onlineshopping.controller;

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

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.repository.CategoryRepository;

@RestController
@RequestMapping("/onlineshopping/api")
public class CategoryRestController {
     
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping("/category")
	public Category addCat(@RequestBody Category catAdd) {
		
		categoryRepository.save(catAdd);
		
		return catAdd;
		
	}
	
	@PutMapping("/category")
	public Category updateCat(@RequestBody Category cat) {
		//Category cat = categoryRepository.findById(catId).get();
		categoryRepository.save(cat);
		return cat;
		
	}
	
	@DeleteMapping("/category/{catId}")
	public Category removeCat( @PathVariable("catId") int catId) {
		Category cat = categoryRepository.findById(catId).get();
		categoryRepository.deleteById(catId);
		return cat;
		
	}
	
	@GetMapping("/category")
	public List<Category> findCat(){
		return categoryRepository.findAll();
	}
	
	
	
}
