package io.chetan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.chetan.model.Owner;


public interface OwnerDao extends CrudRepository<Owner, Long>
{

	public List<Owner> findByPhoneNumber(String phoneNumber);
	//public List<User> findByPhoneNumber(String phoneNumber);
	//public List<User> findByLastName(String lastName);
}
