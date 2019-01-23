package com.mt.restaurant.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.restaurant.model.Restaurant;
import com.mt.restaurant.model.Tables;
import com.mt.restaurant.vo.RestaurantVO;
import com.mt.restaurant.vo.TablesVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	public RestaurantVO maptoRestaurantVO(Restaurant restaurant);
	
	public Restaurant mapVOtoRestaurant(RestaurantVO restaurantVO);
	
	public Set<TablesVO> maptoTablesVOs(Set<Tables> tables);
	
	
	
}
