package com.vishwayan.spring.service;

import java.util.List;

import com.vishwayan.spring.model.RouteSchedule;

public interface RouteScheduleService {

	public void addRouteScheduleDetails(RouteSchedule routeSchedule);
	public void updateRouteScheduleDetails(RouteSchedule routeSchedule);
	public List<RouteSchedule> listRouteScheduleDetails();
	public RouteSchedule getRouteScheduleDetailsById(String routeScheduleId);
	public void removeRouteScheduleDetails(String routeScheduleId);
}
