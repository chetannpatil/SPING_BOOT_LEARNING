package io.chetan.service;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import io.chetan.model.User;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path(value = "/users")
public class UserRestService 
{

	//db
	private static Map<Long,User> inMemoryDb = new HashMap<Long, User>();
	
	//s.I
	static
	{
		User u1 = new User();
		u1.setUserId(1);
		u1.setFirstName("Harees");
		u1.setLastName("raj");
		
		User u2 = new User();
		u2.setUserId(2);
		u2.setFirstName("Raju");
		u2.setLastName("Thalikote");
		
		inMemoryDb.put(u1.getUserId(), u1);
		inMemoryDb.put(u2.getUserId(), u2);
	}
	
	@GET
	@Produces(value = "application/json")
	public Collection<User> getAllUsers()
	{
		return inMemoryDb.values();
	}
	
	@GET
	@Produces(value = "application/json")
	@Path(value = "user/{userId}")
	public Response getUserById(@PathParam("userId") long userId) throws URISyntaxException
	{
		User user = inMemoryDb.get(userId);
		
		if(user == null)
		{
			return Response.status(400).entity("user with id = "+userId+" not found").build();
		}
		else
			return Response.status(200).entity(user).build();

	}
	
	@POST
	@Consumes(value = "application/json")
	@Path(value = "user/create")
	public Response createUser(User user) throws URISyntaxException
	{
		if(user == null || user.getFirstName() == null || user.getLastName()==null)
		{
			return Response.status(400).entity("Ples entre 1stn name n last name").build();
		}
		user.setUserId(inMemoryDb.size()+1);
		inMemoryDb.put(user.getUserId(), user);
		return Response.status(201).build();
	}
	
	@PUT
	@Consumes(value = "application/json")
	@Path(value = "user/update/{userId}")
	@Produces(value = "application/json")
	public Response updateUser(@PathParam("userId") long userId,User user) throws URISyntaxException
	{
		System.out.println("\n updateUser with userid = \n "+userId+" n user = \n "+user);
		if(user == null )
		{
			return Response.status(400).entity("Ples entre 1stn name n last name").build();
		}

		user.setUserId(userId);
		System.out.println("set user = "+user);
		User updatedUSer = inMemoryDb.put(user.getUserId(),user);
		System.out.println("\n updateduser = \n"+updatedUSer);
		return Response.status(200).entity(updatedUSer).build();
	}
	
	@DELETE
	@Path(value = "user/delete/{userId}")
	public Response deleteUser(@PathParam("userId") long userId) throws URISyntaxException
	{
		User user = inMemoryDb.get(userId);
		if(user == null)
		{
			
			return Response.status(400).entity("userid "+userId+" user dosent exist ").build();
		}

		
         User removedUser = inMemoryDb.remove(user.getUserId());
		return Response.status(200).build();
	}
	
	
	
}
