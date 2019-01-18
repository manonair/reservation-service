package com.mt.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mt.restaurant.Tables;
@Repository
public interface TablesRepository extends JpaRepository<Tables, Integer>{

}
