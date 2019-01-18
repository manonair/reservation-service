package com.mt.restaurant;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-18T09:59:23-0600",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class TablesMapperImpl implements TablesMapper {

    @Override
    public TablesVO maptoTablesVO(Tables tables) {
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
