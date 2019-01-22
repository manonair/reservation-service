package com.mt.roster.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResertvationController {


	private Logger LOGGER = LoggerFactory.getLogger(ResertvationController.class);

	@Autowired
    RestTemplate restTemplate;

	@RequestMapping(path = "/{restaurant_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RestaurantVO> getDataTransfer(@PathVariable("restaurant_id") Integer id) {
		RestaurantVO restaurant=null;
		try {
			ResponseEntity<RestaurantVO> responseEntity =restTemplate.exchange("http://RESTAURANT-SERVICE/restaurants/1", HttpMethod.GET, null,new ParameterizedTypeReference<RestaurantVO>() {});
			restaurant= responseEntity.getBody();
		} catch (Exception e) {
			return new ResponseEntity<RestaurantVO>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return restaurant != null ? new ResponseEntity<RestaurantVO>(restaurant, HttpStatus.OK) 
	            : new ResponseEntity<RestaurantVO>(HttpStatus.NO_CONTENT); 
		
	}

	 

}
