package com.mt.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.restaurant.mapper.MenuMapper;
import com.mt.restaurant.model.Menu;
import com.mt.restaurant.repository.MenuRepository;
import com.mt.restaurant.vo.MenuVO;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	MenuMapper menuMapper;
	 
	private Logger LOGGER = LoggerFactory.getLogger(MenuService.class);

	public MenuVO findById(Integer tablesId) {
		Menu menu = menuRepository.findOne(tablesId);
		return mapToMenuVO(menu);
	}

	public List<MenuVO> findAll() throws Exception {
		List<MenuVO> vos = null;
		List<Menu> menus= (List<Menu>) menuRepository.findAll();
		LOGGER.info(" get MenuVO   result size: ", menus.size());
		if (!menus.isEmpty()) {
			vos = menus.stream().map(obj -> mapToMenuVO(obj)).collect(Collectors.toList());
		}
		return vos;
	}

	public Integer createMenu(MenuVO menuVO) {
		Menu entity= menuMapper.mapVOtoMenu(menuVO);
		entity=menuRepository.saveAndFlush(entity);
		return entity.getMenuId();
	}

	public Boolean deleteMenu(Integer menuId) {
		menuRepository.delete(menuId);
		return true;
	}
	
	private MenuVO mapToMenuVO(Menu menu) {
		MenuVO vo=null; 
		vo = menuMapper.maptoMenuVO(menu);
		return vo;
	} 
}
