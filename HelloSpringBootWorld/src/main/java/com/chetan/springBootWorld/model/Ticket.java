package com.chetan.springBootWorld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@NamedQuery(name = "Ticket.findByPrice",query = "SELECT TICKET T FROM TICKET T WHERE T.price =?1")
@Entity
public class Ticket 
{

	@Id
	@GeneratedValue
    private long ticketId;
	
	private double price;
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", price=" + price + "]";
	}

	

	public Ticket(long ticketId, double price) {
		super();
		this.ticketId = ticketId;
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (ticketId ^ (ticketId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
