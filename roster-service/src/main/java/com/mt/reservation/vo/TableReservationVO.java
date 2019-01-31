package com.mt.reservation.vo;

import java.util.Calendar;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TableReservationVO {

	Integer tableReservationId;

	String restaurantName;

	Integer restaurantId;

	Integer tableId;

	Integer userId;

	String status;

	String bookingId;

	Calendar bookingStart;

	Calendar bookingEnd;

	TablesVO tablesVO;
	
	RestaurantVO restaurantVO;
	
	UserVO userVO;

}
