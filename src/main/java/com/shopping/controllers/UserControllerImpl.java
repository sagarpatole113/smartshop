package com.shopping.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.User;
import com.shopping.model.Response;
import com.shopping.model.UserDTO;
import com.shopping.services.UserService;

@CrossOrigin
@RestController
public class UserControllerImpl {
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/signin")
	public ResponseEntity<?> Signin(UserDTO userDto,HttpSession session){
		User user = UserDTO.toEntity(userDto);
		user=userservice.authenticate(user.getEmail(), user.getPassword());
		
		if(user!=null) {
			
		session.setAttribute("user", user);
		UserDTO userdto = UserDTO.fromEntity(user);
		return Response.success(userdto);
		}
		return Response.error("not found");	
	}

	@RequestMapping("/signup")
	public ResponseEntity<?> Signup(UserDTO userDto,HttpSession session){
		User user = UserDTO.toEntity(userDto);
		user=userservice.save(user);
		
		if(user!=null) {
			
		UserDTO userdto = UserDTO.fromEntity(user);
		return Response.success(userdto);
		}
		return Response.error("not found");	
	}

	
	@RequestMapping("/profile/{id}")
	public ResponseEntity<?>profile(@PathVariable("id") int id){
		User user = userservice.findById(id);
		if(user!=null) {	
		UserDTO userdto = UserDTO.fromEntity(user);
		return Response.success(userdto);
		}
		return Response.error("not found");	
	    }
	
	@RequestMapping("/profile1/{email}")
	public ResponseEntity<?>profile(@PathVariable("email") String email){
		System.out.println(email);
		User user = userservice.findByEmail(email);
		System.out.println(user);
		if(user!=null) {	
		UserDTO userdto = UserDTO.fromEntity(user);
		System.out.println(userdto);
		return Response.success(userdto);
		}
		return Response.error("not found");	
	    }
	
	@RequestMapping("/editprofile/{id}")
	public ResponseEntity<?>editprofile(UserDTO userDto, @PathVariable("id") int id){
		User user = userservice.findById(id);
	    user.setCity(userDto.getCity());
	    user.setPhoneno(userDto.getPhoneno());
	    user.setEmail(userDto.getEmail());
	    user.setGender(userDto.getGender());
	    user.setPostalcode(userDto.getPostalcode());
	    user=userservice.save(user);
		UserDTO userdto = UserDTO.fromEntity(user);
		if(userdto!=null) {	
		return Response.success(userdto);
		}
		return Response.error("not found");	
	}
	@RequestMapping("/forgetpassword")
	public ResponseEntity<?>forgetpassword(UserDTO userDto){
		User user = UserDTO.toEntity(userDto);
		user=userservice.findByEmail(user.getEmail());
		if(user!=null) {
			user.setPassword(userDto.getPassword());
			user=userservice.save(user);
		UserDTO userdto = UserDTO.fromEntity(user);
		return Response.success(userdto);
		}
		return Response.error("not found");	
	    }
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<?>delete(@PathVariable("id") int id){
		 boolean status = userservice.deleteById(id);
		if(status) {	
		
		return Response.success("user deleted successfully");
		}
		return Response.error(" user not found");	
	    }

}