package com.mt.restaurant;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TablesMapper {

	TablesMapper INSTANCE = Mappers.getMapper(TablesMapper.class);
	public TablesVO maptoTablesVO(Tables tables);
	
}
