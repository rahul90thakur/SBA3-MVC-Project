package com.wellsfargo.group5.springbootdata.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;
import com.wellsfargo.group5.springbootdata.model.ContactModel;
import com.wellsfargo.group5.springbootdata.repo.ContactRepo;
import com.wellsfargo.group5.springbootdata.util.EntityModelParser;
@Service
public class ContactServiceImpl implements ContactService{
@Autowired	  
private ContactRepo contactrepo;

@Transactional
	@Override
	public ContactModel add(ContactModel contact) throws AddressBookException {
		// TODO Auto-generated method stub
	if(contact!=null) {
		if(contactrepo .existsById(contact.getContactId())) {
			throw new AddressBookException("contact"+ contact.getContactId());
		}
		contact= EntityModelParser.parse(contactrepo.save(EntityModelParser.parse(contact)));
	}
		return contact;
	}
@Transactional
	@Override
	public ContactModel update(ContactModel contact) throws AddressBookException {
		// TODO Auto-generated method stub
	if(contact!=null) {
		if(!contactrepo .existsById(contact.getContactId())) {
			throw new AddressBookException("contact"+ contact.getContactId()+" does not exists");
		}
		contact= EntityModelParser.parse(contactrepo.save(EntityModelParser.parse(contact)));
	}
		return contact;
	}
@Transactional
	@Override
	public void delete(long cid) throws AddressBookException {
		// TODO Auto-generated method stub
		if(!contactrepo .existsById(cid)) {
			throw new AddressBookException("contact"+ cid+" does not exists");
		}
		contactrepo.deleteById(cid);
	}

	@Override
	public ContactModel get(long cid) throws AddressBookException {
		// TODO Auto-generated method stub
		
			if(!contactrepo .existsById(cid)) {
				throw new AddressBookException("contact"+ cid+" does not exists");
			}
		return EntityModelParser.parse(contactrepo.findById(cid).get());
	}

	@Override
	public List<ContactModel> getAll() throws AddressBookException {
		// TODO Auto-generated method stub
		return contactrepo.findAll().stream().map(e->EntityModelParser.parse(e)).collect(Collectors.toList());
	
	}

	@Override
	public List<ContactModel> getAllByGroup(AddressGroupModel group) throws AddressBookException {
		// TODO Auto-generated method stub
		return contactrepo.findAllByAdbGroup(EntityModelParser.parse(group))
				.stream().map(e->EntityModelParser.parse(e)).collect(Collectors.toList());
		
	}
	

}
