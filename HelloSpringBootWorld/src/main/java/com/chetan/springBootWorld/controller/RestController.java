package com.chetan.springBootWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chetan.springBootWorld.model.Ticket;
import com.chetan.springBootWorld.service.TicketService;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
	@Autowired
	TicketService ticketService;
	
//	@Autowired
//	VehicleService vehicleService;

	@GetMapping(value = "/")
	public String get()
	{
		return "hi chetan";
	}
	
	@PostMapping(value = "/createTicket")
	public void createTicket(Ticket t)
	{
		System.out.println("RestController createTicket");
		//t = new Ticket();
		ticketService.createTicket(t);
		System.out.println("tikt = "+t);
		
	}
	@PostMapping(value = "/addTicket")
	public void addTicket(@RequestBody  Ticket t)
	{
		System.out.println("RestController addTicket");
		//t = new Ticket();
		ticketService.addTicket(t);
		System.out.println("tikt = "+t);
		
	}
	
	/*
	 * @GetMapping("/getTicketByPrice") public List<Ticket> findByPrice(double p) {
	 * return ticketService.findByPrice(p); }
	 */
	   
	   //vehcile
	public void DeleteTicket()
	{
		
	}
	
	/*
	 * @GetMapping("/getOwnerByName") public List<Vehicle> findByownerName(String
	 * ownerName) { return vehicleService.findByownerName(ownerName); }
	 * 
	 * 
	 * 
	 * @GetMapping("/getOwnerByVehicleNumber") public Vehicle
	 * findByVehicleNumber(String vehicleNumber) { return
	 * vehicleService.findByVehicleNumber(vehicleNumber); }
	 */
}
