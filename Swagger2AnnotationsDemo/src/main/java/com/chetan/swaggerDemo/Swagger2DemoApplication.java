package com.chetan.swaggerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.chetan.swaggerDemo.dao.ProductDao;
import com.chetan.swaggerDemo.model.Product;

@SpringBootApplication
public class Swagger2DemoApplication implements ApplicationListener<ContextRefreshedEvent>
{

	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args)
	{
		System.out.println("\n Swagger2DemoApplication  main \n");
		SpringApplication.run(Swagger2DemoApplication.class, args);
		
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) 
	{
		System.out.println("\n Swagger2DemoApplication  onApplicationEvent  \n");
		loadProdcuts();
	}

	private void loadProdcuts() 
	{
		System.out.println("\n Swagger2DemoApplication  loadProdcuts  \n");
		
		Product product = new Product();
		product.setImageUrl("www.amazon.com");
		product.setProductId("1323123");
		product.setDescription("1 + 7t");
		
		productDao.save(product);
		
		//2nd
		
		Product product2 = new Product();
		product2.setImageUrl("www.flipkart.com");
		product2.setProductId("9099");
		product2.setDescription("lenevo tab");
		
		productDao.save(product2);
		
	}

}
