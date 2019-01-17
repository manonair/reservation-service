package com.mt.restaurant;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository repository ;

	@Autowired
	RestaurantMapper mapper;
	
	private Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

	public RestaurantVO findById(Integer restaurantId) {
		RestaurantVO vo = null;
		Restaurant  restaurant = repository.findOne(restaurantId);
		
		if (null!=restaurant) {
			vo = mapper.maptoRestaurantVO(restaurant);
		}
		return vo;
	}

	public List<RestaurantVO> findAll() throws Exception {
		List<RestaurantVO> vos = null;
		List<Restaurant> restaurants = (List<Restaurant>) repository.findAll();
		LOGGER.info(" get RestaurantVO   result size: ", restaurants.size());
		if (!restaurants.isEmpty()) {
			vos = restaurants.stream().map(obj -> mapper.maptoRestaurantVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}

}
