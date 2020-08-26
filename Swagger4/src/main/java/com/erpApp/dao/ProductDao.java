package com.erpApp.dao;

import org.springframework.data.repository.CrudRepository;

import com.erpApp.model.Product;



public interface ProductDao extends CrudRepository<Product, Integer>
{

}
