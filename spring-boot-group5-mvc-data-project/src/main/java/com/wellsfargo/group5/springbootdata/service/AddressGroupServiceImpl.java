package com.wellsfargo.group5.springbootdata.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.group5.springbootdata.exception.AddressBookException;
import com.wellsfargo.group5.springbootdata.model.AddressGroupModel;
import com.wellsfargo.group5.springbootdata.repo.AddressGroupRepo;
import com.wellsfargo.group5.springbootdata.util.EntityModelParser;
@Service
public class AddressGroupServiceImpl implements AddressGroupService{
	@Autowired
private AddressGroupRepo agRepo;
	@Transactional
	@Override
	public AddressGroupModel add(AddressGroupModel addressGroup) throws AddressBookException {
		// TODO Auto-generated method stub
		if(addressGroup!=null) {
			if(agRepo.existsById(addressGroup.getGroupId())) {
				throw new AddressBookException("Addressgroup# "+addressGroup.getGroupId()+" Already exited in server");
			}
		addressGroup=	EntityModelParser.parse(agRepo.save(EntityModelParser.parse(addressGroup)));
		}
		return addressGroup;
	}
	@Transactional
	@Override
	public void delete(int groupId) throws AddressBookException {
		// TODO Auto-generated method stub
		if(!agRepo.existsById(groupId)) {
			throw new AddressBookException("Addressgroup# "+groupId+" doesn't exited in server");
		}
		agRepo.deleteById(groupId);
	}

	@Override
	public AddressGroupModel get(int groupId) throws AddressBookException {
		// TODO Auto-generated method stub
		if(!agRepo.existsById(groupId)) {
			throw new AddressBookException("AddressGroup#"+groupId+" does not exists");
		}
		return EntityModelParser.parse(agRepo.findById(groupId).get());
	}

	@Override
	public List<AddressGroupModel> getAll() throws AddressBookException {
		// TODO Auto-generated method stub
		
		return agRepo.findAll().stream().map(e -> EntityModelParser.parse(e)).collect(Collectors.toList());
	}

}
