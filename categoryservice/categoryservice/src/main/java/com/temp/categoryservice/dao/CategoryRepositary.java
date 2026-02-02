package com.temp.categoryservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.temp.categoryservice.entities.Category;


@CrossOrigin
@RepositoryRestResource(path = "category")
public interface CategoryRepositary extends JpaRepository<Category, Integer> {

}
