package com.mt.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	
	@Query(value = "SELECT r  FROM   Restaurant r JOIN FETCH r.tables where r.restaurantId = :id")   
	Restaurant findRestaurantWithTableDetails(@Param("id") Integer id);
	

}
