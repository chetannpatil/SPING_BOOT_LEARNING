package com.chetan.dao;

import org.springframework.data.repository.CrudRepository;

import com.chetan.model.Pen;

public interface PenDao extends CrudRepository<Pen, Long>{

}
