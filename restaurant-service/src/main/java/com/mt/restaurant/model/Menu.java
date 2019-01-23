package com.mt.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MENU")
@Getter
@Setter
@EqualsAndHashCode(of = "menuId")
public class Menu implements java.io.Serializable {

	/*
	 * create table menu ( menu_id integer primary key, item_name varchar(255),
	 * item_desc varchar(255), price integer, status boolean );
	 */
	private static final long serialVersionUID = -1022908280713606265L;
	@Column(name = "menu_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer menuId;

	@Column(name = "item_name", length = 255, nullable = false)
	String itemName;

	@Column(name = "item_desc", length = 255, nullable = false)
	String itemDesc;

	@Column(name = "price")
	Integer price;

	@Column(name = "STATUS", length = 1)
	String status;

}
