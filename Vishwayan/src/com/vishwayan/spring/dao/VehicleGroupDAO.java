package com.vishwayan.spring.dao;

import java.util.List;

import com.vishwayan.spring.model.VehicleGroup;
import com.vishwayan.spring.model.VehicleMaster;

public interface VehicleGroupDAO {

	public void addVehicleGroup(VehicleGroup p);
	public void updateVehicleGroup(VehicleGroup p);
	public List<VehicleGroup> listVehicleGroup();
	public VehicleGroup getVehicleGroupById(String VehicleGroupId);
	public void removeVehicleGroup(String VehicleGroupId);
}
