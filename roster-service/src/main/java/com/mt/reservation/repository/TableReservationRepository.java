package com.mt.reservation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.reservation.model.TableReservation;

@Repository
public interface TableReservationRepository extends CrudRepository<TableReservation, Integer>{
	
	 
	@Query("from TableReservation t  where t.bookingId=:reservationName")
    public Iterable<TableReservation> findByReservationName(@Param("reservationName")String reservationName);
	
}
