package com.mt.restaurant.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TABLES")
@Getter
@Setter
@EqualsAndHashCode(of = "tableId")
public class Tables implements java.io.Serializable {
	/*
	 * CREATE TABLE tables ( TABLE_ID integer PRIMARY KEY, TABLE_NAME VARCHAR(255),
	 * TABLE_DESC VARCHAR(255), CAPACITY INTEGER, STATUS BOOLEAN, BOOKING_START
	 * TIMESTAMP, BOOKING_END TIMESTAMP );
	 */
	private static final long serialVersionUID = -1022908280713606265L;
	@Column(name = "TABLE_ID", nullable = false)
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	Integer tableId;

	@Column(name = "TABLE_TYPE", length = 255, nullable = false)
	String tableType;

	@Column(name = "TABLE_DESC", length = 255, nullable = false)
	String tableDesc;

	@Column(name = "CAPACITY")
	Integer capacity;

	@Column(name = "STATUS", length = 1)
	String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOKING_START")
	Calendar bookingStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOKING_END")
	Calendar bookingEnd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "RESTAURANT_ID") })
	private Restaurant restaurant;
	
}
