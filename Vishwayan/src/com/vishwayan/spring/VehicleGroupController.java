package com.vishwayan.spring;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishwayan.constants.Constant;
import com.vishwayan.spring.model.UserMaster;
import com.vishwayan.spring.model.VehicleGroup;
import com.vishwayan.spring.model.VehicleMaster;
import com.vishwayan.spring.service.VehicleGroupService;

@Controller
public class VehicleGroupController extends BaseController{
	
	private VehicleGroupService vehicleGroupService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleGroupService")
	public void setVehicleGroupService(VehicleGroupService vehicleGroupService){
		this.vehicleGroupService = vehicleGroupService;
	}
	
	@RequestMapping(value = "/VehicleGroupView", method = RequestMethod.GET)
	public String vehicleGroupView(Model model) {	
		model.addAttribute("VehicleGroup", new VehicleGroup());
		 List<VehicleGroup> vehicleGroupList=	this.vehicleGroupService.listVehicleGroup();
			
			ObjectMapper objectMapper = new ObjectMapper();
			String vehicleGroupJSON=null; 
			try {
				vehicleGroupJSON = objectMapper.writeValueAsString(vehicleGroupList);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("vehicleGroupJSON", vehicleGroupJSON);
		return "group_master_view";
	}
	
	
	    //For add and update VehicleMaster both
		@RequestMapping(value= "/AddOrUpdateVehicleGroup", method = RequestMethod.POST)
		public String addVehicleGroup(@ModelAttribute("VehicleGroup") VehicleGroup vehicleGroup,Model model, HttpServletRequest request, HttpServletResponse response){		
			//Add Driver
			VehicleGroup vehicleGroupExist=this.vehicleGroupService.getVehicleGroupById(vehicleGroup.getId());
			if(vehicleGroupExist==null){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				vehicleGroupExist.setCreatedBy(currentUser.getUserName());
				vehicleGroupExist.setCreatedDate(new Date());
				
				vehicleGroupService.addVehicleGroup(vehicleGroup);
				addSuccessMessage("Vehicle group details added successfully.");
				
			} else{
				if(vehicleGroup.isEditFlag()){
					
				vehicleGroupService.updateVehicleGroup(vehicleGroup);
				addSuccessMessage("Vehicle group details updated successfully.");
				}else{
					addErrorMessage("Vehicle group name already exists. Please enter unique value.");
					addSuccessOrErrorMessageToModel(model);
					model.addAttribute("VehicleGroup", vehicleGroup);
					  }

			}
			addSuccessOrErrorMessageToModel(model);
			
			 return vehicleGroupView(model);
						
		}
		
		@RequestMapping("/RemoveVehicleGroupRecord")
	    public String removeDriverMaster(@RequestParam("id") String vehicleGroupId){
			
			vehicleGroupService.removeVehicleGroup(vehicleGroupId);
	        return "redirect:/VehicleGroupView";
	    }
}
