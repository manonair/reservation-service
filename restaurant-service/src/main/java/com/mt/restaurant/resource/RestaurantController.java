package com.mt.restaurant.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.restaurant.service.RestaurantService;
import com.mt.restaurant.vo.RestaurantVO;



@RestController
@RequestMapping("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantController {


	private Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

	@Autowired
	private RestaurantService service;

	@RequestMapping(path = "/{restaurant_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RestaurantVO> getRestaurantById(@PathVariable("restaurant_id") Integer id) {
		RestaurantVO restaurant;
		try {
			restaurant = service.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<RestaurantVO>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return restaurant != null ? new ResponseEntity<RestaurantVO>(restaurant, HttpStatus.OK) 
	            : new ResponseEntity<RestaurantVO>(HttpStatus.NO_CONTENT); 
	}

	
	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<RestaurantVO>> getAllRestaurants() {
		List<RestaurantVO> restaurants;
		try {
			restaurants = service.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<RestaurantVO>>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return restaurants != null ? new ResponseEntity<List<RestaurantVO>>(restaurants, HttpStatus.OK) 
	            : new ResponseEntity<List<RestaurantVO>>(HttpStatus.NO_CONTENT); 
	}
	
	@PostMapping("/add")
    public ResponseEntity<Integer>add(@RequestBody final RestaurantVO restaurantVO) {
		Integer id = service.createRestaurant(restaurantVO);
		return id != null ? new ResponseEntity<Integer>(id, HttpStatus.OK) 
	            : new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }
	
	
	@PostMapping("/delete/{restaurantId}")
    public ResponseEntity<Boolean> delete(@PathVariable("restaurantId") final Integer restaurantId) {
        Boolean status = service.deleteRestaurant(restaurantId);
        return status != null ? new ResponseEntity<Boolean>(status, HttpStatus.OK) 
	            : new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    }
	 

}
