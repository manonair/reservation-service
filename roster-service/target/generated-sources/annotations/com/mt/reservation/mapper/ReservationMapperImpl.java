package com.mt.reservation.mapper;

import com.mt.reservation.model.TableReservation;

import com.mt.reservation.vo.ReservationVO;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-04-07T14:59:03-0500",

    comments = "version: 1.2.0.CR1, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"

)

@Component

public class ReservationMapperImpl implements ReservationMapper {

    @Override

    public ReservationVO maptoTableReservationVO(TableReservation reservation) {

        if ( reservation == null ) {

            return null;
        }

        ReservationVO reservationVO = new ReservationVO();

        reservationVO.setBookingEnd( reservation.getBookingEnd() );

        reservationVO.setBookingStart( reservation.getBookingStart() );

        reservationVO.setTableId( reservation.getTableId() );

        reservationVO.setTableReservationId( reservation.getTableReservationId() );

        reservationVO.setRestaurantId( reservation.getRestaurantId() );

        reservationVO.setUserId( reservation.getUserId() );

        reservationVO.setBookingId( reservation.getBookingId() );

        reservationVO.setStatus( reservation.getStatus() );

        return reservationVO;
    }

    @Override

    public TableReservation maptoEntity(ReservationVO reservationVO) {

        if ( reservationVO == null ) {

            return null;
        }

        TableReservation tableReservation = new TableReservation();

        tableReservation.setTableReservationId( reservationVO.getTableReservationId() );

        tableReservation.setRestaurantId( reservationVO.getRestaurantId() );

        tableReservation.setTableId( reservationVO.getTableId() );

        tableReservation.setUserId( reservationVO.getUserId() );

        tableReservation.setStatus( reservationVO.getStatus() );

        tableReservation.setBookingId( reservationVO.getBookingId() );

        tableReservation.setBookingStart( reservationVO.getBookingStart() );

        tableReservation.setBookingEnd( reservationVO.getBookingEnd() );

        return tableReservation;
    }
}

