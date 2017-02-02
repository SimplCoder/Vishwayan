package com.vishwayan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishwayan.spring.dao.VehicleGroupDAO;
import com.vishwayan.spring.model.VehicleGroup;

@Service("vehicleGroupService")
public class VehicleGroupServiceImpl implements VehicleGroupService {

	@Autowired
	private VehicleGroupDAO vehicleGroupDAO;
	
	@Override
	@Transactional
	public void addVehicleGroup(VehicleGroup vehicleGroup) {
		vehicleGroupDAO.addVehicleGroup(vehicleGroup);
		
	}

	@Override
	@Transactional
	public void updateVehicleGroup(VehicleGroup vehicleGroup) {
		vehicleGroupDAO.updateVehicleGroup(vehicleGroup);
		
	}

	@Override
	@Transactional
	public List<VehicleGroup> listVehicleGroup() {
		return vehicleGroupDAO.listVehicleGroup();
	}

	@Override
	@Transactional
	public VehicleGroup getVehicleGroupById(String VehicleGroupId) {
		return vehicleGroupDAO.getVehicleGroupById(VehicleGroupId);
	}

	@Override
	@Transactional
	public void removeVehicleGroup(String VehicleGroupId) {
		vehicleGroupDAO.removeVehicleGroup(VehicleGroupId);
		
	}

}
