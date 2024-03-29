package com.vishwayan.spring.service;

import java.util.List;

import com.vishwayan.spring.model.VehicleGroup;

public interface VehicleGroupService {
	
	public void addVehicleGroup(VehicleGroup vehicleGroup);
	public void updateVehicleGroup(VehicleGroup vehicleGroup);
	public List<VehicleGroup> listVehicleGroup();
	public VehicleGroup getVehicleGroupById(String VehicleGroupId);
	public void removeVehicleGroup(String VehicleGroupId);
	
}
