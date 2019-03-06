package com.mt.reservation.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TABLE_RESERVATION")
@EqualsAndHashCode(of = "tableReservationId")
@Getter
@Setter
public class TableReservation implements java.io.Serializable{
	 
	private static final long serialVersionUID = -1022908280713606265L;
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	Integer tableReservationId;
	/**
	 */
	@Column(name = "RESTAURANT_ID")
	Integer restaurantId;
	
	
	@Column(name = "TABLE_ID")
	Integer tableId;
	
	@Column(name = "USER_ID")
	Integer userId;
	
	@Column(name = "STATUS", length = 1)
	String status;
	
	
	@Column(name = "BOOKING_ID", length = 50)
	String bookingId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOKING_START")
	Calendar bookingStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOKING_END")
	Calendar bookingEnd;
	
	
 
}
