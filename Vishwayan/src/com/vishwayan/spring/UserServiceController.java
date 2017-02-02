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
import com.vishwayan.spring.service.UserMasterService;

@Controller
public class UserServiceController extends BaseController {
	
	private UserMasterService UserMasterService;
	
	@Autowired(required=true)
	@Qualifier(value="UserMasterService")
	public void setUserMasterService(UserMasterService ps){
		this.UserMasterService = ps;
	}
	
	@RequestMapping(value = "/UserMasters", method = RequestMethod.GET)
	public String listUserMasters(Model model) {
		model.addAttribute("UserMaster", new UserMaster());
	
	    List<UserMaster> UserMasters=	this.UserMasterService.listUserMasters();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String UserMastersJSON=null; 
		try {
			UserMastersJSON = objectMapper.writeValueAsString(UserMasters);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("UserMastersJSON", UserMastersJSON);
		return "user_master_vew";
	}
	 
	//For add and update UserMaster both
	@RequestMapping(value= "/UserMasterSave", method = RequestMethod.POST)
	public String addUserMaster(@ModelAttribute("UserMaster") UserMaster p, Model model,  HttpServletRequest request, HttpServletResponse response){
		
		if(UserMasterService.getUserMasterById(p.getUserName()) ==null){
			//new UserMaster, add it
			UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
			p.setCreatedBy(currentUser.getUserName());
			p.setCreatedDate(new Date());
			
			this.UserMasterService.addUserMaster(p);
			addSuccessMessage("User details added successfully.");
			
		}else{
			//existing UserMaster, call update
			if(p.isEditFlag()){
				UserMaster currentUser=(UserMaster) request.getSession().getAttribute(Constant.CURRENT_USER);
				p.setModifiedBy(currentUser.getUserName());
				p.setModifiedDate(new Date());
				
			this.UserMasterService.updateUserMaster(p);
			addSuccessMessage("User details updated successfully.");
			}else{
				addErrorMessage("User name already exists. Please enter unique value.");
				addSuccessOrErrorMessageToModel(model);
				model.addAttribute("UserMaster", p);
				   return "User_master_entry";
			}
		}

		addSuccessOrErrorMessageToModel(model);
		return listUserMasters(model);
		
	}
	
	@RequestMapping("/UserMasterRemove")
    public String removeUserMaster(@RequestParam("id") String id,Model model){
		
        this.UserMasterService.removeUserMaster(id);
        addSuccessMessage("Vehicle details removed successfully.");
        addSuccessOrErrorMessageToModel(model);
		
        return listUserMasters(model);

    }
  
    @RequestMapping("/UserMasterEdit")
    public String editUserMaster(@RequestParam("id") String id, Model model){
    	if(id.equals("new")){
    		model.addAttribute("UserMaster", new UserMaster());
    	}else{
        
    		UserMaster user= this.UserMasterService.getUserMasterById(id);
    		user.setEditFlag(true);
    		model.addAttribute("UserMaster",user );
        
    	}
        model.addAttribute("listUserMasters", this.UserMasterService.listUserMasters());
        return "User_master_entry";
    }
	
}
