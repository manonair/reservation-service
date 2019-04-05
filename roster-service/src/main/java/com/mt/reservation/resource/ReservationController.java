package com.mt.reservation.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mt.reservation.service.ReservationService;
import com.mt.reservation.vo.ReservationVO;
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

	/*
	 * @RequestMapping(path = "/{restaurant_id}", method = RequestMethod.GET,
	 * produces = "application/json") public ResponseEntity<RestaurantVO>
	 * getReservationbyId(@PathVariable("restaurant_id") Integer id) { RestaurantVO
	 * restaurant=null; try { ResponseEntity<RestaurantVO> responseEntity
	 * =restTemplate.exchange("http://RESTAURANT-SERVICE/restaurants/"+id,
	 * HttpMethod.GET, null,new ParameterizedTypeReference<RestaurantVO>() {});
	 * restaurant= responseEntity.getBody(); } catch (Exception e) { return new
	 * ResponseEntity<RestaurantVO>(HttpStatus.INTERNAL_SERVER_ERROR); } return
	 * restaurant != null ? new ResponseEntity<RestaurantVO>(restaurant,
	 * HttpStatus.OK) : new ResponseEntity<RestaurantVO>(HttpStatus.NO_CONTENT); }
	 */

	@RequestMapping(path = "/{reservation_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ReservationVO> getReservationbyName(@PathVariable("reservation_id") Integer id) {
		ReservationVO reservation = null;
		try {
			reservation = reservationService.findById(id);
		} catch (Exception e) {
			return new ResponseEntity<ReservationVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return reservation != null ? new ResponseEntity<ReservationVO>(reservation, HttpStatus.OK)
				: new ResponseEntity<ReservationVO>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(path = "/search/{reservation_name}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ReservationVO> getReservationbyName(
			@PathVariable("reservation_name") String reservationName) {
		ReservationVO reservation = null;
		try {
			reservation = reservationService.findByReservationName(reservationName);
		} catch (Exception e) {
			return new ResponseEntity<ReservationVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return reservation != null ? new ResponseEntity<ReservationVO>(reservation, HttpStatus.OK)
				: new ResponseEntity<ReservationVO>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ReservationVO>> getAllReservations() {
		List<ReservationVO> reservationVOs = null;
		try {
			reservationVOs = reservationService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<List<ReservationVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return reservationVOs != null ? new ResponseEntity<List<ReservationVO>>(reservationVOs, HttpStatus.OK)
				: new ResponseEntity<List<ReservationVO>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(path = "/user/{user_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ReservationVO>> getAllReservationsByUser(@PathVariable("user_id") Integer userId) {
		List<ReservationVO> reservationVOs = null;
		try {
			reservationVOs = reservationService.findReservationsByUser(userId);
		} catch (Exception e) {
			return new ResponseEntity<List<ReservationVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return reservationVOs != null ? new ResponseEntity<List<ReservationVO>>(reservationVOs, HttpStatus.OK)
				: new ResponseEntity<List<ReservationVO>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(path = "/tables", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ReservationVO>> getAllTablesToReserve() {
		List<ReservationVO> reservationVOs = null;
		try {
			reservationVOs = reservationService.findAvailableTables();
		} catch (Exception e) {
			return new ResponseEntity<List<ReservationVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return reservationVOs != null ? new ResponseEntity<List<ReservationVO>>(reservationVOs, HttpStatus.OK)
				: new ResponseEntity<List<ReservationVO>>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/add", headers = "Content-Type=application/json", method = RequestMethod.POST)
	public ResponseEntity<TableReservationVO> add(@RequestBody TableReservationVO tableReservationVO) {
		TableReservationVO vo = reservationService.createTableReservation(tableReservationVO);
		return vo != null ? new ResponseEntity<TableReservationVO>(vo, HttpStatus.OK)
				: new ResponseEntity<TableReservationVO>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/update")
	public ResponseEntity<TableReservationVO> update(@RequestBody TableReservationVO restaurantVO) {
		TableReservationVO vo = reservationService.createTableReservation(restaurantVO);
		return vo != null ? new ResponseEntity<TableReservationVO>(vo, HttpStatus.OK)
				: new ResponseEntity<TableReservationVO>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/delete/{reservationId}")
	public ResponseEntity<Boolean> delete(@PathVariable("reservationId") final Integer reservationId) {
		Boolean status = reservationService.deleteTableReservation(reservationId);
		return status != null ? new ResponseEntity<Boolean>(status, HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
	}

}
