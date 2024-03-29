package com.vishwayan.spring.dao;

import java.util.List;

import com.vishwayan.spring.model.DriverMaster;

public interface DriverMasterDAO {
	public List<DriverMaster> getDriverMasterList();
	public DriverMaster getDriverMaster(String driverID);
	public void removeDriverMaster(String driverId);
	public void updateDriverMaster(DriverMaster driverMaster);
	public void saveDriverMaster(DriverMaster driverMaster);
}
