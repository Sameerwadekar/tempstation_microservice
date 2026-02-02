package com.temp.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto {
	private int id;
	private String name;
	private BigDecimal price;
	private String description;
	private boolean available;
	private Category category;
	private String productImage;
}
