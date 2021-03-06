package io.chetan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.dao.OwnerDao;
import io.chetan.model.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	
	public Owner createOwner(Owner owner)
	{
		return ownerDao.save(owner);
	}
	
	public Iterable<Owner>  findAllOwners()
	{
		return  ownerDao.findAll();
	}
	
	public List<Owner> findByPhoneNumber(String phoneNumber)
	{
		return ownerDao.findByPhoneNumber(phoneNumber);
	}
}
