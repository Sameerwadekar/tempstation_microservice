package com.temp.productservice.service;

import java.util.List;

import com.temp.productservice.dto.ProductDto;



public interface ProductService {
	ProductDto addProduct(ProductDto productDto);
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	ProductDto updateProductbyId(int id,ProductDto productDto);
	void deleteProduct(int id);
//	ProductDto assignCategory(int pid,int cid);
}
