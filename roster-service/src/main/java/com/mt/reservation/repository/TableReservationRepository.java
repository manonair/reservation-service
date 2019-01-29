package com.mt.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.reservation.model.TableReservation;

@Repository
public interface TableReservationRepository extends JpaRepository<TableReservation, Integer>{
	
	 
	

}
