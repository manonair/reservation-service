package com.mt.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.reservation.model.TableReservation;
import com.mt.reservation.vo.TableReservationVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TableReservationMapper {

	TableReservationMapper INSTANCE = Mappers.getMapper(TableReservationMapper.class);
	public TableReservationVO maptoTableReservationVO(TableReservation reservation);
	
	public TableReservation maptoEntity(TableReservationVO reservationVO);
	
	
	 
	
	
	
}
