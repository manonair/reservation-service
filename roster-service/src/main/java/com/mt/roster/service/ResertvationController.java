package com.mt.roster.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResertvationController {


	private Logger LOGGER = LoggerFactory.getLogger(ResertvationController.class);

 

	@RequestMapping(path = "/{restaurant_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RestaurantVO> getDataTransfer(@PathVariable("restaurant_id") Integer id) {
		RestaurantVO restaurant=null;
		try {
//			restaurant = service.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<RestaurantVO>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return restaurant != null ? new ResponseEntity<RestaurantVO>(restaurant, HttpStatus.OK) 
	            : new ResponseEntity<RestaurantVO>(HttpStatus.NO_CONTENT); 
		
	}

	 

}
