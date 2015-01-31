package com.notify.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.notify.model.B2BUser;
import com.notify.model.ForgotPwd;
import com.notify.model.JsonResponseModel;
import com.notify.services.B2BUserService;



@Controller
public class LoginController {
	
	@Autowired
	B2BUserService b2bUserService;

	
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout){
		ModelAndView model = new ModelAndView();
		  if (error != null) {
			model.addObject("error", "Invalid username and password!");
		  }
	 
		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("loginForm");
	 
		  return model;
	}
	
	
	@RequestMapping(value="/welcome" ,method=RequestMethod.GET)
	public String welcomePage(ModelMap model,Principal principal){
		String email = principal.getName();
		B2BUser b2bUser = b2bUserService.getB2BUser(email);
		model.addAttribute("user", b2bUser);
		return "welcome";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)  
	 public String logout(ModelMap model) {  
	   
	  return "redirect:/login";  
	   
	 }
	
	@RequestMapping(value="/forgotPwd",method=RequestMethod.GET)
	public String showForgotPwdForm(Model model)
	{

		model.addAttribute("forgotPwd", new ForgotPwd());
		return "forgotPassword";
	}
	@RequestMapping(value="/forgotPwd",method=RequestMethod.POST)
	public @ResponseBody JsonResponseModel mailNewPasswod(@Valid ForgotPwd forgotPwd,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model)
	{
		JsonResponseModel jsonResponse = new JsonResponseModel();
		
		
		B2BUser b2bUser = b2bUserService.getB2BUser(forgotPwd.getEmail());
		
		if(b2bUser == null)
		{
			jsonResponse.setMessage("Sorry... no account found with the email <b>'"+forgotPwd.getEmail()+"'</b>");
			jsonResponse.setStatus("FAILURE");
		}else
		{
			boolean emailSent = b2bUserService.sendEmailForgottenPassword(b2bUser);
			if(emailSent)
			{
				jsonResponse.setMessage("Password sent to your email");
				jsonResponse.setStatus("SUCCESS");
			}
		}
		
		
		
		return jsonResponse;
	}


	public B2BUserService getB2bUserService() {
		return b2bUserService;
	}


	public void setB2bUserService(B2BUserService b2bUserService) {
		this.b2bUserService = b2bUserService;
	}
	
	
	
	
	
}
