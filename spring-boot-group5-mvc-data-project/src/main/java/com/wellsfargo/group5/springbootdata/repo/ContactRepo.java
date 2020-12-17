package com.wellsfargo.group5.springbootdata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.group5.springbootdata.entity.AddressGroupEntity;
import com.wellsfargo.group5.springbootdata.entity.ContactEntity;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Long>{

	List<ContactEntity> findAllByAdbGroup(AddressGroupEntity adbGroup);

}
