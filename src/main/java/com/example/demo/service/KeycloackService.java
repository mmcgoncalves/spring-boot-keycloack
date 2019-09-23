package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloackService {

	@Autowired
	private HttpServletRequest request;	
	
	@Value("${keycloak.realm}")
	private String realm;

	@Value("${keycloak.resource}")
	private String clientId;


	
	public String getName() {				
		return getKeycloakSecurityContext().getToken().getGivenName();		
	}
	
	public List<String> getRoles() {
		Set<String> roles = getKeycloakSecurityContext().getToken().getResourceAccess(clientId).getRoles();				
		return new ArrayList<String>(roles);
	}
	
	private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

}
