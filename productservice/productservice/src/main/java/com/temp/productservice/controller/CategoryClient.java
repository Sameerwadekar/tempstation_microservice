package com.temp.productservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.temp.productservice.dto.Category;

@FeignClient(name = "CATEGORYSERVICE")
public interface CategoryClient {
	@GetMapping("/category/{id}")
	Category getCategory(@PathVariable int id);
}
