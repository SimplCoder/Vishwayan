package com.vishwayan.spring.service;

import java.util.List;

import com.vishwayan.spring.model.UserMaster;

public interface UserMasterService {

	public void addUserMaster(UserMaster p);
	public void updateUserMaster(UserMaster p);
	public List<UserMaster> listUserMasters();
	public UserMaster getUserMasterById(String userName);
	public void removeUserMaster(String userName);
	
}
