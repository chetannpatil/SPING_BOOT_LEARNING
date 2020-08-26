package com.chetan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.chetan.dao.PenDao;
import com.chetan.model.Pen;

@SpringBootApplication
public class HibernateJpaDemoApplication {

	@Autowired
	private PenDao penDao;
	
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HibernateJpaDemoApplication.class, args);
		
		Pen p = new Pen(3, "aaaaaaaa", 3232.2);
		
		PenDao penDao2 = applicationContext.getBean(PenDao.class);
		
		Pen savedPen = penDao2.save(p);
		
		System.out.println("end main with savedpen = \n"+savedPen);
		
		
	}

}
