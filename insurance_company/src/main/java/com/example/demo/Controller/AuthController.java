package com.example.demo.Controller;


import java.security.KeyStoreException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.ServiceProviderRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.AdminService;
import com.example.demo.Services.CompanyService;
import com.example.demo.Services.ServiceProviderService;
import com.example.demo.Services.UserService;
import com.example.demo.model.Admin;
import com.example.demo.model.Company;
import com.example.demo.model.ServiceProvider;
import com.example.demo.model.User;
import com.example.demo.security.JWTResponse;
import com.example.demo.security.TokenUtiles;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AdminRepository adminRepository ;
	@Autowired
	private CompanyRepository companyRepository ;
	@Autowired
	private ServiceProviderRepository serviceProviderRepository ;
	
	  @Autowired
	    private TokenUtiles tokenUtiles;
	  @Autowired
	    private UserRepository userRepository;
	  @Autowired
	    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JWTResponse signup(@RequestParam("username")String username, @RequestParam("password")String password)  {
    	System.out.println(username);
    	
    	try {
    	    	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
    	    			password));
    	    	
    	    	User user=userService.getUserByUsername(username);
    	    	
    	    	String authenticationToken="";
    	     if(user.getServiceProviderId()==0&&user.getCompanyId()==0) {
    	    	 String type="admin";
    	    	 Admin admin=adminRepository.findById(user.getAdminId()).get();
    	    	  authenticationToken = tokenUtiles.generateToken(admin.getFirstname(),type);
    	    	 
    	     }
    	     if(user.getServiceProviderId()==0&&user.getAdminId()==0) {
    	    	
    	    	 String type="company";
    	    	 System.out.println(user.getCompanyId());
    	    	 Company company=companyRepository.findById(user.getCompanyId()).get();
    	    	 
    	    	 authenticationToken = tokenUtiles.generateToken(company.getName(),type);
    	     }
    	     if(user.getAdminId()==0&&user.getCompanyId()==0) {
    	    	 String type="serviceProvider";
    	    	 ServiceProvider serviceprovider=serviceProviderRepository.findById(user.getServiceProviderId()).get();
    	    	 authenticationToken = tokenUtiles.generateToken(serviceprovider.getName(),type);
    	     }
    	        
    	        System.out.println(authenticationToken);
    	        return new JWTResponse(authenticationToken, username);
    	    
    	}catch (Exception e) {
    		System.out.println("dfhhdfhds");
    		return null;
    		
		}
    			
 

    	   }

   @PostMapping("/signup")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public User signup(@RequestBody  User user) {
    	System.out.println(user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    	 return user;
    	
       
    }
    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    public User getUser(@PathVariable("id") long id) {
    	return userRepository.findById(id).get();
    }
   
 
}
