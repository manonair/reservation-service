package com.mt.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.reservation.model.TableReservation;
import com.mt.reservation.vo.ReservationVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

	ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

	@Mappings({
	      @Mapping(target="tableReservationId", source="tableReservationId"),
	      @Mapping(target="restaurantId", source="restaurantId"),
	      @Mapping(target="tableId", source="tableId"),
	      @Mapping(target="userId", source="userId"),
	      @Mapping(target="status", source="status"),
	      @Mapping(target="bookingId", source="bookingId"),
	      @Mapping(target="bookingStart", source="bookingStart"),
	      @Mapping(target="bookingEnd", source="bookingEnd")
	    })
	public ReservationVO maptoTableReservationVO(TableReservation reservation);
	
	public TableReservation maptoEntity(ReservationVO reservationVO);
	
	
	 
	
	
	
}
