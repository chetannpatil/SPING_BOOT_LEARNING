package com.chetan.swaggerDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.swaggerDemo.dao.ProductDao;
import com.chetan.swaggerDemo.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "onlineStore")
@RequestMapping(value = "/product")
public class ProdcutController 
{

	@Autowired
	private ProductDao productDao ;
	
	@ApiOperation(value = "view alist of avaliable prdcts",response = Iterable.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200,message = "succsfully retived list"),
		@ApiResponse(code = 401,message = "u rnot autrzed 2 view resp"),	
		@ApiResponse(code = 403,message = "accesing th resourc u were trying t reah forbiddent"),	
		@ApiResponse(code = 404,message = "resource u r trying is not found")	
	}
	)
	@RequestMapping(value = "/list",method = RequestMethod.GET,produces = "application/json")
	public Iterable<Product> list()
	{
		System.out.println("\n ProdcutController list \n");
		return productDao.findAll();
	}
	
	
	//sjhow
	@ApiOperation(value = "search a prdcut with an id",response = Product.class)
	@RequestMapping(value = "/show/{id}",method = RequestMethod.GET,produces = "application/json")
	public Product showProdcuts(@PathVariable("id") Integer id)
	{
		System.out.println("\n ProdcutController showProdcuts \n");
		 Optional<Product> optional = productDao.findById(id);
		 
		 Product product = optional.get() ;
		 
		 System.out.println("retrved prd from optional = \n "+product);
		 
		 return product ;
		 
	}
	
	//add
	@ApiOperation(value = "add a prdcut")
	@RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<String> addAProdcut(@RequestBody Product product)
	{
		System.out.println("\n ProdcutController addAProdcut \n");
		// Optional<Product> optional = productDao.findById(id);
		 
		// Product product = optional.get() ;
		 
		// 
		 Product product2 = productDao.save(product);
		 System.out.println("saved prd = \n "+product2);
		 return new ResponseEntity<String>("savedsccusfully ",HttpStatus.OK) ;
		 
	}
	
	//update
	@ApiOperation(value = "update  prdcut")
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<String> updateProdcut(@RequestBody Product product
			,@PathVariable("id") Integer id)
	{
		System.out.println("\n ProdcutController updateProdcut \n");
		
		Optional<Product> storedPrd = productDao.findById(id);
		Product oldProd = storedPrd.get();
		 System.out.println("oldProd prd = \n "+oldProd);
		oldProd.setDescription(product.getDescription());
		oldProd.setImageUrl(product.getImageUrl());
		 System.out.println("updated prd = \n "+oldProd);
		 
		 productDao.save(oldProd);
		 return new ResponseEntity<String>("updated sccusfully ",HttpStatus.OK) ;
		 
	}
	
	//delete
	@ApiOperation(value = "delete  prdcut")
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<String> deleteProdcut(@PathVariable("id") Integer id)
	{
		System.out.println("\n ProdcutController deleteProdcut \n");
		
			 productDao.deleteById(id);
		 return new ResponseEntity<String>("deleted sccusfully ",HttpStatus.OK) ;
		 
	}
	@RequestMapping(value = "/")
	public String hello()
	{
		System.out.println("\n ProdcutController hello \n");
		return "Hi from swagger app2 a greetings :)";
	}
}
