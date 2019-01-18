package com.mt.restaurant;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository repository ;

	@Autowired
	private TablesRepository tablesRepository;
	
	@Autowired
	RestaurantMapper mapper;
	
	
	@Autowired
	TablesMapper tablesMapper ;
	
	
	private Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);

	public RestaurantVO findById(Integer restaurantId) {
		RestaurantVO vo = null;
		Restaurant  restaurant = repository.findRestaurantWithTableDetails(restaurantId);
		
		if (null!=restaurant) {
			vo = mapper.maptoRestaurantVO(restaurant);
			Set<TablesVO> tabels = mapper.maptoTablesVOs(restaurant.getTables());
			vo.setTablesVOs(tabels);
			
		}
		return vo;
	}

	public List<RestaurantVO> findAll() throws Exception {
		List<RestaurantVO> vos = null;
		List<Restaurant> restaurants = (List<Restaurant>) repository.findAll();
		LOGGER.info(" get RestaurantVO   result size: ", restaurants.size());
		if (!restaurants.isEmpty()) {
			vos = restaurants.stream().map(obj -> mapToRestaurantVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}
	
	
	public List<RestaurantVO> findRestaurantTableDetails() throws Exception {
		List<RestaurantVO> vos = null;
		List<Restaurant> restaurants = (List<Restaurant>) repository.findAll();
		LOGGER.info(" get RestaurantVO   result size: ", restaurants.size());
		if (!restaurants.isEmpty()) {
			vos = restaurants.stream().map(obj -> mapToRestaurantVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}
	
	
	private RestaurantVO mapToRestaurantVO(Restaurant restaurant) {
		RestaurantVO vo = mapper.maptoRestaurantVO(restaurant);
		if(!CollectionUtils.isEmpty(restaurant.getTables())) {
			Set<TablesVO> tabels = mapper.maptoTablesVOs(restaurant.getTables());
			vo.setTablesVOs(tabels);
		}
		return vo;
	} 
	
	
	
	
	public List<TablesVO> findAllTables() throws Exception {
		List<TablesVO> vos = null;
		List<Tables> tables = (List<Tables>) tablesRepository.findAll();
		LOGGER.info(" get RestaurantVO   result size: ", tables.size());
		if (!tables.isEmpty()) {
			vos = tables.stream().map(obj -> tablesMapper.maptoTablesVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}

}
