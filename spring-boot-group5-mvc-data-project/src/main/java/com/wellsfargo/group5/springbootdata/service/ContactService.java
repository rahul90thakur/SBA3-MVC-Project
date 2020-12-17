package com.wellsfargo.group5.springbootdata.service;

import java.util.List;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;
import com.wellsfargo.group5.springbootdata.model.ContactModel;

public interface ContactService {
/*
 * add
 * delete
 * get
 * getAll
 */
	ContactModel add(ContactModel contact) throws AddressBookException;
	ContactModel update(ContactModel contact) throws AddressBookException;
	void delete(long cid) throws AddressBookException;
	ContactModel get(long cid) throws AddressBookException;	
	List<ContactModel> getAll() throws AddressBookException;
	List<ContactModel> getAllByGroup(AddressGroupModel group) throws AddressBookException;
	
}
