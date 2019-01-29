package com.mt.reservation.resource;

import java.util.List;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mt.reservation.service.ReservationService;
import com.mt.reservation.vo.RestaurantVO;
import com.mt.reservation.vo.TableReservationVO;



@RestController
@RequestMapping("/reservation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationController {


	private Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
    RestTemplate restTemplate;
	
	
	@Autowired
	ReservationService reservationService;

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


	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TableReservationVO>> getAllReservations() {
		List<TableReservationVO> reservationVOs=null;
		try {
			reservationVOs = reservationService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<TableReservationVO>>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return reservationVOs != null ? new ResponseEntity<List<TableReservationVO>>(reservationVOs, HttpStatus.OK) 
	            : new ResponseEntity<List<TableReservationVO>>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
	@PostMapping("/add")
    public ResponseEntity<Integer>add(@RequestBody final TableReservationVO restaurantVO) {
		Integer id = reservationService.createTableReservation(restaurantVO);
		return id != null ? new ResponseEntity<Integer>(id, HttpStatus.OK) 
	            : new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
    }
	
	
	@PostMapping("/delete/{reservationId}")
    public ResponseEntity<Boolean> delete(@PathVariable("reservationId") final Integer reservationId) {
        Boolean status = reservationService.deleteTableReservation(reservationId);
        return status != null ? new ResponseEntity<Boolean>(status, HttpStatus.OK) 
	            : new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    }
	 
	
	

}
