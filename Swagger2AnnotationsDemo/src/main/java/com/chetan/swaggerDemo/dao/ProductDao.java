package com.chetan.swaggerDemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.chetan.swaggerDemo.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer>
{

}
