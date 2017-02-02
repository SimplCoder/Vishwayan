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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishwayan.constants.Constant;
import com.vishwayan.spring.model.UserMaster;
import com.vishwayan.spring.model.VehicleMaster;
import com.vishwayan.spring.service.VehicleMasterService;

@Controller
public class VehicleServiceController extends BaseController {
	
	private VehicleMasterService vehicleMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="vehicleMasterService")
	public void setVehicleMasterService(VehicleMasterService ps){
		this.vehicleMasterService = ps;
	}
	
	@RequestMapping(value = "/VehicleMasters", method = RequestMethod.GET)
	public String listVehicleMasters(Model model , HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("VehicleMaster", new VehicleMaster());
	
	    List<VehicleMaster> vehicleMasters=	this.vehicleMasterService.listVehicleMasters();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String vehicleMastersJSON=null; 
		try {
			vehicleMastersJSON = objectMapper.writeValueAsString(vehicleMasters);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("vehicleMastersJSON", vehicleMastersJSON);
		return "Vehicle_master_view";
	}
	 
	//For add and update VehicleMaster both
	@RequestMapping(value= "/VehicleMasterSave", method = RequestMethod.POST)
	public String addVehicleMaster(@ModelAttribute("VehicleMaster") VehicleMaster p, Model model, HttpServletRequest request, HttpServletResponse response){
		if(vehicleMasterService.getVehicleMasterById(p.getVehicleNo()) ==null){
			//new VehicleMaster, add it
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			p.setCreatedBy(currentUser.getUserName());
			p.setCreatedDate(new Date());
			this.vehicleMasterService.addVehicleMaster(p);
			addSuccessMessage("Vehicle details added successfully.");
			
		}else{
			//existing VehicleMaster, call update
			if(p.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				p.setModifiedBy(currentUser.getUserName());
				p.setModifiedDate(new Date());
				this.vehicleMasterService.updateVehicleMaster(p);
				addSuccessMessage("Vehicle details updated successfully.");
			}else{
				addErrorMessage("Vehicle Number already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("VehicleMaster", p);
				   return "Vehicle_master_addNew";
			}
		}
		addSuccessOrErrorMessageToModel(model);
		return listVehicleMasters(model,request,response);
		
	}
	
	@RequestMapping("/VehicleMasterRemove")
    public String removeVehicleMaster(@RequestParam("id") String id, Model model, HttpServletRequest request, HttpServletResponse response){
		
        this.vehicleMasterService.removeVehicleMaster(id);
        addSuccessMessage("Vehicle details removed successfully.");
        addSuccessOrErrorMessageToModel(model);
		
        return listVehicleMasters(model,request,response);
    }
  
    @RequestMapping("/VehicleMasterEdit")
    public String editVehicleMaster(@RequestParam("id") String id, Model model, HttpServletRequest request, HttpServletResponse response){
    	if(id.equals("new")){
    		model.addAttribute("VehicleMaster", new VehicleMaster());
    	}else{
    		VehicleMaster vehicleMaster=vehicleMasterService.getVehicleMasterById(id);
    		vehicleMaster.setEditFlag(true);
        model.addAttribute("VehicleMaster",vehicleMaster );
        }
        model.addAttribute("listVehicleMasters", this.vehicleMasterService.listVehicleMasters());
        return "Vehicle_master_addNew";
    }
	
}
