package com.erpApp.dao;

import java.util.List;

import org.aspectj.weaver.tools.Trace;
import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.erpApp.model.User;



public interface  UserDao extends CrudRepository<User, Long>{

	public List<User> findByLastName(String lastName);
	
	@Query(value = "select u from User u where u.firstName = ?1 AND u.email = ?2")
	public List<User> findByFirstNameAndEmail(String firstName,String email);
	
	@Query(value = "SELECT u FROM User u WHERE u.email = ?1")
	public List<User> searchByEmail(String e);
	
//	public List<User> fetchByFirstNameAndEmail(String firstName,String email);

	public List<User> getByEmailAndAdharNumber(String email, String adharNumber);
	
	@Query(value = "SELECT * FROM USER WHERE adhar=?1 ",nativeQuery =true)
	public User getByAdhar(String a);

}
