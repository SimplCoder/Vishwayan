package com.vishwayan.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishwayan.spring.dao.DeviceMasterDAO;
import com.vishwayan.spring.dao.UserMasterDAO;
import com.vishwayan.spring.model.DeviceMaster;
import com.vishwayan.spring.model.UserMaster;

@Service("deviceMasterService")

public class DeviceMasterServiceImpl implements DeviceMasterService {
	
	@Autowired
	private DeviceMasterDAO deviceMasterDAO;

	

	public DeviceMasterDAO getDeviceMasterDAO() {
		return deviceMasterDAO;
	}

	public void setDeviceMasterDAO(DeviceMasterDAO deviceMasterDAO) {
		this.deviceMasterDAO = deviceMasterDAO;
	}


	@Override
	@Transactional
	public void addDeviceMaster(DeviceMaster p) {
		deviceMasterDAO.addDeviceMaster(p);
	}

	@Override
	@Transactional
	public void updateDeviceMaster(DeviceMaster p) {
		deviceMasterDAO.updateDeviceMaster(p);
	}

	@Override
	@Transactional
	public List<DeviceMaster> listDeviceMasters() {
		return deviceMasterDAO.listDeviceMaster();
	}

	@Override
	@Transactional
	public DeviceMaster getDeviceMasterById(String deviceNo) {
		
		return deviceMasterDAO.getDeviceMasterByDeviceNo(deviceNo);
	}

	@Override
	@Transactional
	public void removeDeviceMaster(String deviceNo) {
		deviceMasterDAO.removeDeviceMaster(deviceNo);
		
	}

}
