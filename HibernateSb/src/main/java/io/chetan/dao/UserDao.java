package io.chetan.dao;

import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.chetan.model.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createUser(User user)
	{
		System.out.println("\n UserDao  createUser strted\n");
		Session session = null ;
		
		try
		{
			// session = sessionFactory.openSession();
			//session = sessionFactory.openSession();
			session = sessionFactory.getCurrentSession() ;
			
			session.beginTransaction();
			
	          Integer savedInt =  (Integer) session.save(user);
			System.out.println("\n UserDao createUser created with id = \n "+savedInt);
		 session.getTransaction().commit(); 
		
		
		} 
		catch (Exception e) 
		{
			System.out.println("\n UserDao  createUser catch e = \n"+e.getMessage());
			e.printStackTrace();
		} 
		finally
		{
			if(session != null)
				session.close();
		}
	}
}
