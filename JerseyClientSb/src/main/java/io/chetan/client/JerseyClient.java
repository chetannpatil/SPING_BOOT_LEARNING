package io.chetan.client;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.chetan.model.User;

public class JerseyClient 
{
	/*
	 * static Client client = ClientBuilder.newClient() ;
	 * 
	 * WebTarget target = client.target("http://localhost:8080/users");
	 */
     Client client  = null ;
 
	//get
	
	public static void main(String[] args) 
	{
		JerseyClient jerseyClient = new JerseyClient() ;
		
		  System.out.println("\n JerseyClient main calling getall\n");
		  
		  jerseyClient.getAllUsers();
		 
		
		
		
		  System.out.println("\n JerseyClient main calling getByid of 2 \n");
		  jerseyClient.getById(2);
		 
		
		  System.out.println("\n JerseyClient main calling post\n");
		  
		  User newUser = new User(); newUser.setFirstName("Rashmi");
		  newUser.setLastName("Jajjuri");
		  
		  jerseyClient.craeteUser(newUser);
    
		    System.out.println("\n ---------------JerseyClient main finally calling getall\n");
			  
			  jerseyClient.getAllUsers();
		  
		
		  System.out.println("\n JerseyClient main calling update\n"); User updateuser
		  = new User(); updateuser.setUserId(1); updateuser.setFirstName("Chitra");
		  updateuser.setLastName("kotur"); jerseyClient.updateUser(updateuser);
		 
           System.out.println("\n ---------------JerseyClient main finally calling getall\n");
		  
		  jerseyClient.getAllUsers();
		
		  System.out.println("\n JerseyClient main calling delete\n");
		  jerseyClient.deleteUser(2);
		 
		
		  System.out.println("\n JerseyClient main finally calling getall\n");
		  
		  jerseyClient.getAllUsers();
		 
		 
		 
		 
		
		
	}
	public void getAllUsers()
	{
		System.out.println("\nJerseyClient getAllUsers\n");
		
		try 
		{
			  client = ClientBuilder.newClient() ;
				
				WebTarget target = client.target("http://localhost:8080/users");
//			client =  ClientBuilder.newClient() ;
			
			
			//WebTarget put = target.path("user/update");
			
			 List<User> list = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>()
			 {
				 
			 });
			
			System.out.println("\n response list = \n "+list);
			//System.out.println("\n\n response sttaus = \n "+response.getStatus());
			System.out.println("\n response list eleemtns are  = \n ");
			list.stream().forEach(System.out::println);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();
		}
	}
	
	//getbyid
	
	public void getById(long userId)
	{
		System.out.println("\nJerseyClient getById\n");
		
		try 
		{
			  client = ClientBuilder.newClient() ;
				
				WebTarget target = client.target("http://localhost:8080/users");
			
			
			WebTarget get = target.path("user");
			  
			WebTarget webTargetByUserId = get.path("{userId}").resolveTemplate("userId", userId);
			//Response response = webTargetByUserId.request(MediaType.APPLICATION_JSON).get();
			
			User user2 = webTargetByUserId.request(MediaType.APPLICATION_JSON).get(User.class);
			/*
			 * Object entity = response.getEntity(); User user = null; if(entity instanceof
			 * User) { user = (User) entity ; }
			 * System.out.println("\n response  = \n "+response);
			 * System.out.println("\n\n response sttaus = \n "+response.getStatus());
			 */
			
			//System.out.println("\n user getbuid user = \n"+user);
			
			System.out.println("\n user getbuid user2 = \n"+user2);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();
		}
	}
	
	public void craeteUser(User user)
	{
		
		System.out.println("\nJerseyClient craeteUser\n");
		try 
		{
			
			  client = ClientBuilder.newClient() ;
				
				WebTarget target = client.target("http://localhost:8080/us ers");
			
			WebTarget add = target.path("user/create");
			 
			Response response = add.request(MediaType.APPLICATION_JSON).post(Entity.json(user));
			
			System.out.println("\n response  = \n "+response);
			System.out.println("\n\n response sttaus = \n "+response.getStatus());
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();
		}
	}
	
	public void updateUser(User user)
	{
		System.out.println("\nJerseyClient updateUser\n");
		
		try 
		{
			  client = ClientBuilder.newClient() ;
				
				WebTarget target = client.target("http://localhost:8080/users");
			
			
			WebTarget put = target.path("user/update");
			 
			WebTarget putwebTarget = put.path("{userId}").resolveTemplate("userId", user.getUserId());
			Response response = putwebTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(user));
			
			System.out.println("\n putwebTarget response  = \n "+response);
			System.out.println("\n\n putwebTarget response sttaus = \n "+response.getStatus());
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();
		}
	}
	
	public void deleteUser(long userId)
	{
		System.out.println("\nJerseyClient updateUser\n");
		
		try 
		{
			  client = ClientBuilder.newClient() ;
				
				WebTarget target = client.target("http://localhost:8080/users");
			
			
			WebTarget delete = target.path("user/delete");
			 
			WebTarget deletewebTarget = delete.path("{userId}").resolveTemplate("userId",userId);
			Response response = deletewebTarget.request(MediaType.APPLICATION_JSON).delete();
			
			System.out.println("\n deletewebTarget response  = \n "+response);
			System.out.println("\n\n deletewebTarget response sttaus = \n "+response.getStatus());
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			client.close();
		}
	}
}
