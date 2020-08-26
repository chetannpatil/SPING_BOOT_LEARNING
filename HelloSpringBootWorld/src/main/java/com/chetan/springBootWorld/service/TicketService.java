package com.chetan.springBootWorld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.springBootWorld.dao.TicketDao;
import com.chetan.springBootWorld.model.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	public void addTicket(Ticket t) 
	{
		ticketDao.save(t);
	}

	public void createTicket(Ticket t)
	{

		ticketDao.save(t);
	}
	
	/*
	 * public List<Ticket> findByPrice(double p) { return ticketDao.findByPrice(p);
	 * }
	 */
}
