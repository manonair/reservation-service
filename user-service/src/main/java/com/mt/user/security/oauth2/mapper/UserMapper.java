package com.mt.user.security.oauth2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mt.user.security.oauth2.model.security.User;
import com.mt.user.security.oauth2.vo.UserVO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	public UserVO maptoMenuVO(User user);
	
	public User mapVOtoMenu(UserVO userVO);
	
}
