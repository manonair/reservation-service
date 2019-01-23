package com.mt.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.restaurant.model.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
