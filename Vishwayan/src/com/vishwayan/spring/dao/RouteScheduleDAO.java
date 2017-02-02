package com.vishwayan.spring.dao;

import java.util.List;

import com.vishwayan.spring.model.RouteSchedule;

public interface RouteScheduleDAO {

	public void addRouteScheduleDetails(RouteSchedule routeSchedule);
	public void updateRouteScheduleDetails(RouteSchedule routeSchedule);
	public List<RouteSchedule> listRouteScheduleDetails();
	public RouteSchedule getRouteScheduleDetailsById(String routeScheduleId);
	public void removeRouteScheduleDetails(String routeScheduleId);
}
