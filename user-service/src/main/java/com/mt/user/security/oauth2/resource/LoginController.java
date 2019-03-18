package com.mt.user.security.oauth2.resource;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt.user.security.oauth2.model.security.User;
import com.mt.user.security.oauth2.service.UserDetailsServiceImpl;

 

@RestController
public class LoginController {

	@Autowired
	UserDetailsServiceImpl userService;
	
	@Value("${security.oauth2.client.accessTokenUri}")
	 private String accessTokenUri;
	
	@Value("${app.auth.base65}")
	 private String authorization;
 
	
	
	
	@RequestMapping(path="/login",method=RequestMethod.POST,consumes  = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUser(@RequestBody MultiValueMap<String, String> formData) {
		User user = null;
		HttpHeaders headerOut =null;
		try {
			String token = getOathTocken(formData);
			headerOut = getResponseHeader(token);
			
			String userName=formData.getFirst("username").toString();
			String pwd=formData.getFirst("password").toString();
			if(null!=userName && null!=pwd) {
				user = userService.getUserByUsername(userName, pwd);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  user != null ? new ResponseEntity<User>(user,headerOut, HttpStatus.OK) 
				: new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}


	private String getOathTocken(MultiValueMap<String, String> formData) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String access_token_url = accessTokenUri;
		HttpHeaders headers = populateSecureHeader(); 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(formData,headers);
		ResponseEntity<String> response  = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();
		return token;
	}


	private HttpHeaders getResponseHeader(String token) {
		HttpHeaders headerOut = new HttpHeaders();
		headerOut.add("Authorization", "Bearer " + token);
		headerOut.add("Content-Type", "application/json; charset=UTF-8");
		return headerOut;
	}


	private HttpHeaders populateSecureHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authorization );
		headers.add("content-type", "application/x-www-form-urlencoded" ); 
		headers.add("No-Auth", "True" );
		return headers;
	}
	
	

	
}
