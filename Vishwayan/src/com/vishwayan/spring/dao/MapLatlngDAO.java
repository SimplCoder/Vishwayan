package com.vishwayan.spring.dao;

import java.util.List;

public interface MapLatlngDAO {
	public List getAllVehicleLocation(); 
	public List getLatlngDetailsByVehicleNo(String vehicleNo, String fromDate, String toDate);
}
