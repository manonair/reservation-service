package com.mt.reservation.vo;

import java.util.Calendar;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ReservationVO {

	Integer tableReservationId;
	
	String name;
	
	Integer tableId;
	
	String tableType;
	
	String tableDesc;
	
	Integer capacity;
	
	String status;
	
	Calendar bookingStart;
	
	Calendar bookingEnd;
	
	Integer restaurantId;
	
	String restaurantName;
	
	String bookingId;
	
	Integer userId;

}
