package com.mt.restaurant.vo;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesVO implements java.io.Serializable {
	private static final long serialVersionUID = -1022908280713606265L;
	
	
	Integer tableId;

	String tableType;

	String tableDesc;

	Integer capacity;

	String status;

	Calendar bookingStart;

	Calendar bookingEnd;
	
	private RestaurantVO restaurantVO;

}
