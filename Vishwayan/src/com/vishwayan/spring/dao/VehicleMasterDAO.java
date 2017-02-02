package com.vishwayan.spring.dao;

import java.util.List;

import com.vishwayan.spring.model.VehicleMaster;

public interface VehicleMasterDAO {

	public void addVehicleMaster(VehicleMaster p);
	public void updateVehicleMaster(VehicleMaster p);
	public List<VehicleMaster> listVehicleMasters();
	public VehicleMaster getVehicleMasterById(String vehicleNo);
	public void removeVehicleMaster(String vehicleNo);
	public int totaNoOffVehicle();
}
