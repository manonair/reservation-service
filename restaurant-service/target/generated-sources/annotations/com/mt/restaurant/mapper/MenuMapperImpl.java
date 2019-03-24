package com.mt.restaurant.mapper;

import com.mt.restaurant.model.Menu;
import com.mt.restaurant.vo.MenuVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-23T09:45:32-0500",
    comments = "version: 1.2.0.CR1, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public MenuVO maptoMenuVO(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuVO menuVO = new MenuVO();

        menuVO.setMenuId( menu.getMenuId() );
        menuVO.setItemName( menu.getItemName() );
        menuVO.setItemDesc( menu.getItemDesc() );
        menuVO.setPrice( menu.getPrice() );
        menuVO.setStatus( menu.getStatus() );

        return menuVO;
    }

    @Override
    public Menu mapVOtoMenu(MenuVO menuVO) {
        if ( menuVO == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setMenuId( menuVO.getMenuId() );
        menu.setItemName( menuVO.getItemName() );
        menu.setItemDesc( menuVO.getItemDesc() );
        menu.setPrice( menuVO.getPrice() );
        menu.setStatus( menuVO.getStatus() );

        return menu;
    }
}
