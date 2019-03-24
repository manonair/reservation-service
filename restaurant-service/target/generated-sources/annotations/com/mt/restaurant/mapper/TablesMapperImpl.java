package com.mt.restaurant.mapper;

import com.mt.restaurant.model.Tables;
import com.mt.restaurant.vo.TablesVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-23T09:45:33-0500",
    comments = "version: 1.2.0.CR1, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
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

    @Override
    public Tables mapVOtoTables(TablesVO tableVO) {
        if ( tableVO == null ) {
            return null;
        }

        Tables tables = new Tables();

        tables.setTableId( tableVO.getTableId() );
        tables.setTableType( tableVO.getTableType() );
        tables.setTableDesc( tableVO.getTableDesc() );
        tables.setCapacity( tableVO.getCapacity() );
        tables.setStatus( tableVO.getStatus() );
        tables.setBookingStart( tableVO.getBookingStart() );
        tables.setBookingEnd( tableVO.getBookingEnd() );

        return tables;
    }
}
