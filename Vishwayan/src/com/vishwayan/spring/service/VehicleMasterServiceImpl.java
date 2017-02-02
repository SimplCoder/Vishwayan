package com.vishwayan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishwayan.spring.dao.VehicleMasterDAO;
import com.vishwayan.spring.model.VehicleMaster;

@Service("vehicleMasterService")
public class VehicleMasterServiceImpl implements VehicleMasterService {
	
	@Autowired
	private VehicleMasterDAO vehicleMasterDAO;

	public void setVehicleMasterDAO(VehicleMasterDAO vehicleMasterDAO) {
		this.vehicleMasterDAO = vehicleMasterDAO;
	}

	@Override
	@Transactional
	public void addVehicleMaster(VehicleMaster p) {
		this.vehicleMasterDAO.addVehicleMaster(p);
	}

	@Override
	@Transactional
	public void updateVehicleMaster(VehicleMaster p) {
		this.vehicleMasterDAO.updateVehicleMaster(p);
	}

	@Override
	@Transactional
	public List<VehicleMaster> listVehicleMasters() {
		return this.vehicleMasterDAO.listVehicleMasters();
	}

	@Override
	@Transactional
	public VehicleMaster getVehicleMasterById(String vehicleNo) {
		return this.vehicleMasterDAO.getVehicleMasterById(vehicleNo);
	}

	@Override
	@Transactional
	public void removeVehicleMaster(String vehicleNo) {
		this.vehicleMasterDAO.removeVehicleMaster(vehicleNo);
	}

	@Override
	@Transactional
	public int totaNoOffVehicle() {
		// TODO Auto-generated method stub
		return this.vehicleMasterDAO.totaNoOffVehicle();
	}

}
