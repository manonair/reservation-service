package com.mt.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.reservation.model.TableReservation;

@Repository
public interface TableReservationRepository extends CrudRepository<TableReservation, Integer>{
	
	 
	

}
