package com.mt.restaurant.mapper;

import com.mt.restaurant.model.Restaurant;
import com.mt.restaurant.model.Tables;
import com.mt.restaurant.vo.RestaurantVO;
import com.mt.restaurant.vo.TablesVO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-10T19:07:20-0500",
    comments = "version: 1.2.0.CR1, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public RestaurantVO maptoRestaurantVO(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantVO restaurantVO = new RestaurantVO();

        restaurantVO.setRestaurantId( restaurant.getRestaurantId() );
        restaurantVO.setRestaurantName( restaurant.getRestaurantName() );
        restaurantVO.setStatus( restaurant.getStatus() );

        return restaurantVO;
    }

    @Override
    public Restaurant mapVOtoRestaurant(RestaurantVO restaurantVO) {
        if ( restaurantVO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId( restaurantVO.getRestaurantId() );
        restaurant.setRestaurantName( restaurantVO.getRestaurantName() );
        restaurant.setStatus( restaurantVO.getStatus() );

        return restaurant;
    }

    @Override
    public Set<TablesVO> maptoTablesVOs(Set<Tables> tables) {
        if ( tables == null ) {
            return null;
        }

        Set<TablesVO> set = new HashSet<TablesVO>( Math.max( (int) ( tables.size() / .75f ) + 1, 16 ) );
        for ( Tables tables1 : tables ) {
            set.add( tablesToTablesVO( tables1 ) );
        }

        return set;
    }

    protected TablesVO tablesToTablesVO(Tables tables) {
        if ( tables == null ) {
            return null;
        }

        TablesVO tablesVO = new TablesVO();

        tablesVO.setTableId( tables.getTableId() );
        tablesVO.setTableType( tables.getTableType() );
        tablesVO.setTableDesc( tables.getTableDesc() );
        tablesVO.setCapacity( tables.getCapacity() );
        tablesVO.setStatus( tables.getStatus() );
        tablesVO.setBookingStart( tables.getBookingStart() );
        tablesVO.setBookingEnd( tables.getBookingEnd() );

        return tablesVO;
    }
}
