package com.vishwayan.spring.service;

import java.util.List;

import com.vishwayan.spring.model.DeviceMaster;

public interface DeviceMasterService {

	public void addDeviceMaster(DeviceMaster p);
	public void updateDeviceMaster(DeviceMaster p);
	public List<DeviceMaster> listDeviceMasters();
	public DeviceMaster getDeviceMasterById(String deviceNo);
	public void removeDeviceMaster(String userName);
	
}
