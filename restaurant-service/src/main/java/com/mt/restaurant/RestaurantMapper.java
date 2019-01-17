package com.mt.restaurant;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	public RestaurantVO maptoRestaurantVO(Restaurant restaurant);
	
}
