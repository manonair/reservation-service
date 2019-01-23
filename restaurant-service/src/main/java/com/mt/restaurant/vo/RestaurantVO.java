package com.mt.restaurant.vo;

import lombok.Data;

@Data
public class RestaurantVO {

	private Integer restaurantId;

	private String restaurantName;

	private String status;
	
	java.util.Set<TablesVO> tablesVOs;
	

}
