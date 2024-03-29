package com.vishwayan.spring.service;

import java.util.List;

import com.vishwayan.spring.model.DriverMaster;

public interface DriverMasterService {
	public void addDriverMaster(DriverMaster driverMaster);
	public void updateDriverMaster(DriverMaster driverMaster);
	public List<DriverMaster> getDriverMasterList();
	public DriverMaster getDriverMasterById(String driverId);
	public void removeDriverMaster(String driverId);
}
