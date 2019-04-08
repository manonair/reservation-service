package com.mt.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.reservation.model.TableReservation;
import com.mt.reservation.vo.TableReservationVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TableReservationMapper {

	TableReservationMapper INSTANCE = Mappers.getMapper(TableReservationMapper.class);
	@Mapping(source = "bookingStart", dateFormat = "yyyy-MM-ddTHH:mm:ss", target = "bookingStart")
	public TableReservationVO maptoTableReservationVO(TableReservation reservation);
	
	@Mapping(source = "bookingStart", dateFormat = "yyyy-MM-ddTHH:mm:ss", target = "bookingStart")
	@Mapping(source = "bookingEnd", dateFormat = "yyyy-MM-ddTHH:mm:ss", target = "bookingEnd")
	public TableReservation maptoEntity(TableReservationVO reservationVO);
	
	
	 
	
	
	
}
