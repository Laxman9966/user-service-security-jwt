package com.app.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.auth.config.JwtResponse;
import com.app.auth.config.JwtTokenUtil;
import com.app.auth.config.SignInDto;
import com.app.auth.model.PocUser;
import com.app.service.AppUserService;

@RestController
@CrossOrigin
@RequestMapping("auth")
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AppUserService appUserService;
	
	@RequestMapping(value="helloo", method=RequestMethod.GET)
	public String helloo() {
		return "This api requires token";
	}
	
	@RequestMapping(value="/hui", method=RequestMethod.POST)
	public String hui(@RequestBody PocUser pocuser) {
		System.out.println("JSON STRING OF INPUT DATA " +pocuser);
		return "This api requires token";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public PocUser addStudent(@RequestBody PocUser pocUser) {
		return appUserService.saveUser(pocUser);
	}
	
	@RequestMapping(value ="/usersignin" , method = RequestMethod.POST)
	public ResponseEntity<?> studentSignIn(@RequestBody @Valid SignInDto signInDto) throws Exception {
		System.out.println("####### signInDto "+signInDto);
		authenticate(signInDto.getUsername(), signInDto.getPassword());
		//final UserDetails userDetails = appUserService.loadUserByUsername(signInDto.getUsername());
		final UserDetails userDetails = appUserService.loadUserByUsernameUserType(signInDto.getUsername(),signInDto.getUsertype() );
		//userDetails.
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token,signInDto.getUsertype(),appUserService.getSid(),appUserService.getName()));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
}
