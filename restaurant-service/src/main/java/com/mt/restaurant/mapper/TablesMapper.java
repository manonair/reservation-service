package com.mt.restaurant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.restaurant.model.Tables;
import com.mt.restaurant.vo.TablesVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TablesMapper {

	TablesMapper INSTANCE = Mappers.getMapper(TablesMapper.class);
	public TablesVO maptoTablesVO(Tables tables);
	
	public Tables mapVOtoTables(TablesVO tableVO);
	
}
