package com.mt.restaurant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.restaurant.model.Menu;
import com.mt.restaurant.vo.MenuVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {

	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
	public MenuVO maptoMenuVO(Menu menu);
	
	public Menu mapVOtoMenu(MenuVO menuVO);
	
}
