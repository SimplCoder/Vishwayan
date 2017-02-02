package com.vishwayan.spring.dao;

import java.util.List;

import com.vishwayan.spring.model.DeviceMaster;
import com.vishwayan.spring.model.UserMaster;

public interface DeviceMasterDAO {

	public void addDeviceMaster(DeviceMaster deviceMaster);
	public void updateDeviceMaster(DeviceMaster deviceMaster);
	public List<DeviceMaster> listDeviceMaster();
	public DeviceMaster getDeviceMasterByDeviceNo(String deviceNo);
	public void removeDeviceMaster(String deviceNo);
}
