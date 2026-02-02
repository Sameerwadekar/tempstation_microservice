package com.temp.productservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temp.productservice.controller.CategoryClient;
import com.temp.productservice.dao.ProductRepositary;
import com.temp.productservice.dto.Category;
import com.temp.productservice.dto.ProductDto;
import com.temp.productservice.entities.Product;

import feign.FeignException;
import feign.FeignException.FeignClientException;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private  ModelMapper modelMapper;
	
	@Autowired
	private  ProductRepositary productRepositary;
	
	@Autowired
	private CategoryClient categoryClient;

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		try {
			Category category = categoryClient.getCategory(productDto.getCategoryId());
		} catch (FeignException.NotFound ex) {
			throw new RuntimeException("id not found");
		}
		Product product = modelMapper.map(productDto, Product.class);
		product.setCategoryId(productDto.getCategoryId());
		Product saved = productRepositary.save(product);
		ProductDto savedDto = modelMapper.map(saved, ProductDto.class);
		return savedDto;
	}

//	@Override
//	public List<ProductDto> getAllProducts() {
//		List<Product> products = productRepositary.findAll();
//		List<ProductDto> list = products.stream().map((e)->modelMapper.map(e, ProductDto.class)).toList();
//		return list;
//	}
//
//	@Override
//	public ProductDto getProductById(int id) {
//		Product product = productRepositary.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
//		ProductDto productDto = modelMapper.map(product, ProductDto.class);
//		return productDto;
//	}
//
//	@Override
//	public ProductDto updateProductbyId(int id, ProductDto productDto) {
//		Product product = productRepositary.findById(id).orElseThrow(()->new RuntimeException("id not found"));
//		Category category = categoryRepositary.findById(productDto.getCategoryId()).orElseThrow(()->new RuntimeException("category id not found"));
//		product.setDescription(productDto.getDescription());
//		product.setName(productDto.getName());
//		product.setPrice(productDto.getPrice());
//		product.setCategory(category);
//		Product savedproduct = productRepositary.save(product);
//		ProductDto savedDto = modelMapper.map(savedproduct, ProductDto.class);	
//		return savedDto;
//	}
//
//	@Override
//	public void deleteProduct(int id) {
//		Product product = productRepositary.findById(id).orElseThrow(()-> new RuntimeException("id not found"));
//		int pid = product.getId();
//		productRepositary.deleteById(pid);
//	}
//	@Override
//	public ProductDto assignCategory(int pid, int cid) {
//		Product product = productRepositary.findById(pid).orElseThrow(()-> new RuntimeException("id not found"));
//		Category category = categoryRepositary.findById(cid).orElseThrow(()-> new RuntimeException("id not found"));
//		product.setCategory(category);
//		Product savedProduct = productRepositary.save(product);
//		ProductDto productDto = modelMapper.map(savedProduct, ProductDto.class);		
//		return productDto;
//	}

}
