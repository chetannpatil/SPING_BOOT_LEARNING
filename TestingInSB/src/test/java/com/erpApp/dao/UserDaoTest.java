package com.erpApp.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.erpApp.model.User;

@DataJpaTest
//@SpringBootTest
public class UserDaoTest {

	@Autowired
	private TestEntityManager testEntityManager ;
	
	@Autowired
	private UserDao userDao ;
	
	
	
	/*
	 * @Test void testFindByLastName() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindByFirstNameAndEmail() { fail("Not yet implemented"); }
	 * 
	 * @Test void testSearchByEmail() { fail("Not yet implemented"); }
	 * 
	 * @Test void testGetByEmailAndAdharNumber() { fail("Not yet implemented"); }
	 * 
	 * @Test void testGetByAdhar() { fail("Not yet implemented"); }
	 */
	@Test
	void testSave()
	{
		User u = new User() ;
		if(testEntityManager != null)
		{
			System.out.println("\n testEntityManager not null \n");
			User savedUser = testEntityManager.persist(u);
			
			Optional<User> userFromDboptional = userDao.findById(savedUser.getUserId());
			 
			User fetchedUser = userFromDboptional.get();
			
		//	assertEquals(savedUser, fetchedUser);
			
			assertThat(savedUser).isEqualTo(fetchedUser);
		}
		else
		{
			System.out.println("\n testEntityManager is null \n");
		}
		
		
	}
	/*
	 * @Test void testSaveAll() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindById() { fail("Not yet implemented"); }
	 * 
	 * @Test void testExistsById() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindAll() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindAllById() { fail("Not yet implemented"); }
	 * 
	 * @Test void testCount() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeleteById() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDelete() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeleteAllIterableOfQextendsT() { fail("Not yet implemented");
	 * }
	 * 
	 * @Test void testDeleteAll() { fail("Not yet implemented"); }
	 */

}
