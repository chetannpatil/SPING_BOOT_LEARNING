package com.chetan.springBootWorld.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chetan.springBootWorld.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket,Long>
{
	//public List<Ticket> findByPrice(double p);
	
}
