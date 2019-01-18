package com.mt.restaurant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESTAURANTS")
@Getter
@Setter
@EqualsAndHashCode(of = "restaurantId")
public class Restaurant implements java.io.Serializable{
	 
	private static final long serialVersionUID = -1022908280713606265L;
	@Column(name = "RESTAURANT_ID", nullable = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer restaurantId;
	/**
	 */

	@Column(name = "RESTAURANT_NAME", length = 255, nullable = false)
	String restaurantName;
	/**
	 */

	@Column(name = "STATUS", length = 1)
	String status;
	
	
	@OneToMany(mappedBy = "restaurant", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	java.util.Set<Tables> tables;
}
