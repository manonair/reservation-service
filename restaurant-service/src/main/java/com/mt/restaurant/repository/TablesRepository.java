package com.mt.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.restaurant.model.Tables;
@Repository
public interface TablesRepository extends JpaRepository<Tables, Integer>{

}
