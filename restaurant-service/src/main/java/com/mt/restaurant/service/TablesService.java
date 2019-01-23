package com.mt.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.restaurant.mapper.RestaurantMapper;
import com.mt.restaurant.mapper.TablesMapper;
import com.mt.restaurant.model.Restaurant;
import com.mt.restaurant.model.Tables;
import com.mt.restaurant.repository.RestaurantRepository;
import com.mt.restaurant.repository.TablesRepository;
import com.mt.restaurant.vo.RestaurantVO;
import com.mt.restaurant.vo.TablesVO;

@Service
public class TablesService {

	@Autowired
	private RestaurantRepository restaurantRepository ;

	@Autowired
	private TablesRepository tablesRepository;
	
	@Autowired
	RestaurantMapper restaurantMapper;
	
	
	
	@Autowired
	TablesMapper tablesMapper ;
	
	
	private Logger LOGGER = LoggerFactory.getLogger(TablesService.class);

	public TablesVO findById(Integer tablesId) {
		Tables  tables = tablesRepository.findOne(tablesId);
		return mapToTablesVO(tables);
	}

	public List<TablesVO> findAll() throws Exception {
		List<TablesVO> vos = null;
		List<Tables> tablesList = (List<Tables>) tablesRepository.findAll();
		LOGGER.info(" get TablesVO   result size: ", tablesList.size());
		if (!tablesList.isEmpty()) {
			vos = tablesList.stream().map(obj -> mapToTablesVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}
	
		
	public List<TablesVO> findAllTables() throws Exception {
		List<TablesVO> vos = null;
		List<Tables> tables = (List<Tables>) tablesRepository.findAll();
		LOGGER.info(" get TablesVO   result size: ", tables.size());
		if (!tables.isEmpty()) {
			vos = tables.stream().map(obj -> mapToTablesVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}

	public Integer createTables(TablesVO tablesVO) {
		RestaurantVO restaurantVO= tablesVO.getRestaurantVO();
		Tables entity= tablesMapper.mapVOtoTables(tablesVO);
		if(null!=restaurantVO) {
			Integer id =  restaurantVO.getRestaurantId();
			if(null!=id) {
				Restaurant restaurant= restaurantRepository.findOne(id);
				entity.setRestaurant(restaurant);
			}		
		}
		entity=tablesRepository.saveAndFlush(entity);
		return entity.getTableId();
	}

	public Boolean deleteTables(Integer tableId) {
		tablesRepository.delete(tableId);
		return true;
	}

	
	
	private TablesVO mapToTablesVO(Tables tables) {
		TablesVO vo=null; 
		vo = tablesMapper.maptoTablesVO(tables);
		if(null!=tables.getRestaurant()) {
			RestaurantVO restaurantVO = restaurantMapper.maptoRestaurantVO(tables.getRestaurant());
			vo.setRestaurantVO(restaurantVO);
		}
		return vo;
	} 
}
