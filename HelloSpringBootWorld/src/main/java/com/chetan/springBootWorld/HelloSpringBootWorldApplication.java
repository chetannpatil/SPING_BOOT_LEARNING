package com.chetan.springBootWorld;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.chetan.springBootWorld.model.Ticket;
import com.chetan.springBootWorld.service.TicketService;

@SpringBootApplication
public class HelloSpringBootWorldApplication// implements CommandLineRunner 
{

	/*
	 * @Autowired private TicketService ticketService;
	 */
//	private static TicketService ticketService;
	/*
	 * @Autowired private DataSource dataSource;
	 */
	/*
	 * @Autowired private VehicleService vehicleService;
	 */

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloSpringBootWorldApplication.class,
				args);
		TicketService ticketService = applicationContext.getBean("ticketService", TicketService.class);
		
		Ticket t = new Ticket();
		t.setPrice(420);
		
		Ticket t2 = new Ticket();
		t.setPrice(45345);
		
		Ticket t3 = new Ticket();
		t.setPrice(45345);
		
		Ticket t4 = new Ticket();
		t.setPrice(420);
		
		ticketService.createTicket(t);
		ticketService.createTicket(t2);
		ticketService.createTicket(t3);
		ticketService.createTicket(t4);
	//	System.out.println("data source= \n "+dataSource);

	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * Ticket t = new Ticket(); t.setPrice(420);
	 * 
	 * Ticket t2 = new Ticket(); t.setPrice(45345);
	 * 
	 * Ticket t3 = new Ticket(); t.setPrice(45345);
	 * 
	 * Ticket t4 = new Ticket(); t.setPrice(420);
	 * 
	 * ticketService.createTicket(t); ticketService.createTicket(t2);
	 * ticketService.createTicket(t3); ticketService.createTicket(t4);
	 * System.out.println("data source= \n "+dataSource);
	 * 
	 * 
	 * Vehicle v1 = new Vehicle();
	 * 
	 * v1.setName("bus"); v1.setOwnerName("Chetan"); v1.setPrice(2343432);
	 * v1.setVehicleNumber("KA01z0009");
	 * 
	 * Vehicle v2 = new Vehicle();
	 * 
	 * v1.setName("bike"); v1.setOwnerName("aditya"); v1.setPrice(345334);
	 * v1.setVehicleNumber("TN45z0049");
	 * 
	 * 
	 * Vehicle v3 = new Vehicle();
	 * 
	 * v1.setName("rikshaw"); v1.setOwnerName("hema"); v1.setPrice(345562);
	 * v1.setVehicleNumber("ap01ee339");
	 * 
	 * 
	 * 
	 * vehicleService.createVehicle(v1); vehicleService.createVehicle(v2);
	 * vehicleService.createVehicle(v3);
	 * 
	 * }
	 */

}
