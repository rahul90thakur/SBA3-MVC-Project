package com.wellsfargo.group5.springbootdata.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class AddressGroupModel {
	
	@NotNull(message="Group ID can not be Blank")
	private Integer groupId;
	
	@NotNull(message="Group Title can not be Blank")
	@NotBlank(message="Group Title can not be Blank")
	@Size(min=4,max=50,message="group title must be btwn 4 to 50 chars")
	private String groupTitle;
	
	


	public AddressGroupModel() {
		
	}
	
	public AddressGroupModel(Integer groupId, String groupTitle) {
		super();
		this.groupId = groupId;
		this.groupTitle = groupTitle;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	
	
}