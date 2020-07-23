package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Services.AdminService;
import com.example.demo.Services.CompanyService;
import com.example.demo.Services.ServiceProviderService;
import com.example.demo.model.Admin;
import com.example.demo.model.Company;
import com.example.demo.model.ServiceProvider;




public class AuthFilter  extends OncePerRequestFilter{

	private String TOKEN_HEADER = "Authorization" ;

	@Autowired
	private TokenUtiles tokenUtil ;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader(TOKEN_HEADER);
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        if (header != null && securityContext.getAuthentication() == null) {
        	System.out.println(header);
            String token = header.substring("Bearer ".length());
            String username = tokenUtil.getUserNameFromToken(token);
            String type=(String)tokenUtil.getClaims(token).get("type");
            if(username != null) {
            switch (type) {
			case "admin":
				Admin admin=adminService.getAdminByname(username);
                if (tokenUtil.isTokenValid(token)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(admin, null,null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
				break;
			case "company":
				System.out.println("company");
				Company company=companyService.getCompany(username);
                if (tokenUtil.isTokenValid(token)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(company, null,null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
				break;
			case "serviceProvider":
				ServiceProvider serviceprovider=serviceProviderService.getServiceProvider(username);
                if (tokenUtil.isTokenValid(token)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(serviceprovider, null,null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
				break;
			default:
				break;
			}
                
            }
        }


        filterChain.doFilter(request, response);
    }
}
