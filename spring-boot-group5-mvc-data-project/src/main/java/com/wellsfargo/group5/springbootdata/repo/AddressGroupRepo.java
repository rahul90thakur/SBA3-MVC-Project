package com.wellsfargo.group5.springbootdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.group5.springbootdata.entity.AddressGroupEntity;

@Repository
public interface AddressGroupRepo extends JpaRepository<AddressGroupEntity, Integer>{

}
