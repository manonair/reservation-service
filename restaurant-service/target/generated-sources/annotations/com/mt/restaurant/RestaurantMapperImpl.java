package com.mt.restaurant;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-18T13:58:53-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
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
