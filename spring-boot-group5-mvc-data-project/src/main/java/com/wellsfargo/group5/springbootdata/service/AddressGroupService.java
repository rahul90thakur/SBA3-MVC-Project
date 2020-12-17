package com.wellsfargo.group5.springbootdata.service;

import java.util.List;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;

public interface AddressGroupService {
/*
 * add
 * delete
 * get
 * getAll
 */
	AddressGroupModel add(AddressGroupModel addressGroup) throws AddressBookException ;
	void delete(int groupId) throws AddressBookException;
	AddressGroupModel get(int groupId) throws AddressBookException;
	List<AddressGroupModel> getAll() throws AddressBookException;
	
}
