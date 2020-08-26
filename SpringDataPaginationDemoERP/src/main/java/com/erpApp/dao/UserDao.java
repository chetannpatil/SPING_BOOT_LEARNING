package com.erpApp.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.erpApp.model.User;



public interface  UserDao extends CrudRepository<User, Long>
{

	List<User> getUsersByLastName(String lastName, Pageable p);
	
	List<User> findUsersByLastName(String lastName, Pageable of);

	//List<User> findUsersByLastName(String lastName, PageRequest of);

	//List<User> fetchUsersByLastName(String lastName, Pageable of);

	//List<User> fetchUsersByf_name(String f_name, Pageable of);

	List<User> getUsersByfirstName(String firstName, Pageable of);

	@Async
	CompletableFuture<User> getUsersByfirstName(String firstName);

	@Query(name = "select u from User u where u.firstName =:firstName or u.lastName=:lastName")
	List<User> getUsersByfirstNameOrLastName(@Param("firstName")String firstName,@Param("lastName") String lastName);

	@Transactional
	@Modifying
	@Query(value ="update User set f_name =:firstName where email=:email")
	int updateUserF_nameByEmail(@Param("email") String email, @Param("firstName")  String firstName);

	@Modifying
	@Transactional
	@Query(value ="update User set lastName =:lastName where email=:email")
	int updateUserLastNameByEmail(@Param("email") String email, @Param("lastName")  String lastName);
	
	//Lis
	
	

	

}
