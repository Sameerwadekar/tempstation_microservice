package com.temp.productservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.temp.productservice.entities.Product;



@RepositoryRestResource(path = "product")
@CrossOrigin
public interface ProductRepositary extends JpaRepository<Product, Integer>{

		List<Product> findByAvailableTrue();
		List<Product> findByCategoryIdAndAvailableTrue(Integer categoryId);
}
