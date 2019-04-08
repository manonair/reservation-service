package com.mt.reservation.mapper;

import com.mt.reservation.model.TableReservation;

import com.mt.reservation.vo.TableReservationVO;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-04-07T14:59:02-0500",

    comments = "version: 1.2.0.CR1, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"

)

@Component

public class TableReservationMapperImpl implements TableReservationMapper {

    @Override

    public TableReservationVO maptoTableReservationVO(TableReservation reservation) {

        if ( reservation == null ) {

            return null;
        }

        TableReservationVO tableReservationVO = new TableReservationVO();

        tableReservationVO.setBookingStart( reservation.getBookingStart() );

        tableReservationVO.setTableReservationId( reservation.getTableReservationId() );

        tableReservationVO.setRestaurantId( reservation.getRestaurantId() );

        tableReservationVO.setTableId( reservation.getTableId() );

        tableReservationVO.setUserId( reservation.getUserId() );

        tableReservationVO.setStatus( reservation.getStatus() );

        tableReservationVO.setBookingId( reservation.getBookingId() );

        tableReservationVO.setBookingEnd( reservation.getBookingEnd() );

        return tableReservationVO;
    }

    @Override

    public TableReservation maptoEntity(TableReservationVO reservationVO) {

        if ( reservationVO == null ) {

            return null;
        }

        TableReservation tableReservation = new TableReservation();

        tableReservation.setBookingStart( reservationVO.getBookingStart() );

        tableReservation.setBookingEnd( reservationVO.getBookingEnd() );

        tableReservation.setTableReservationId( reservationVO.getTableReservationId() );

        tableReservation.setRestaurantId( reservationVO.getRestaurantId() );

        tableReservation.setTableId( reservationVO.getTableId() );

        tableReservation.setUserId( reservationVO.getUserId() );

        tableReservation.setStatus( reservationVO.getStatus() );

        tableReservation.setBookingId( reservationVO.getBookingId() );

        return tableReservation;
    }
}

