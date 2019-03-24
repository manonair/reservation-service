package com.mt.user.security.oauth2.mapper;

import com.mt.user.security.oauth2.model.security.User;
import com.mt.user.security.oauth2.vo.UserVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-23T09:45:12-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserVO maptoMenuVO(User user) {
        if ( user == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( user.getId() );
        userVO.setUsername( user.getUsername() );
        userVO.setPassword( user.getPassword() );
        userVO.setAccountExpired( user.isAccountExpired() );
        userVO.setAccountLocked( user.isAccountLocked() );
        userVO.setCredentialsExpired( user.isCredentialsExpired() );
        userVO.setEnabled( user.isEnabled() );
        userVO.setAccessToken( user.getAccessToken() );

        return userVO;
    }

    @Override
    public User mapVOtoMenu(UserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userVO.getId() );
        user.setUsername( userVO.getUsername() );
        user.setPassword( userVO.getPassword() );
        user.setAccountExpired( userVO.isAccountExpired() );
        user.setAccountLocked( userVO.isAccountLocked() );
        user.setCredentialsExpired( userVO.isCredentialsExpired() );
        user.setEnabled( userVO.isEnabled() );
        user.setAccessToken( userVO.getAccessToken() );

        return user;
    }
}
