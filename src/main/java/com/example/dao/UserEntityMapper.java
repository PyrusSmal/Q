package com.example.dao;

import com.example.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Mapper
public interface UserEntityMapper {
    List<UserEntity> queryUserList(UserEntity userEntity);
    int insert(UserEntity userEntity);
    int deleteUserByName(UserEntity userEntity);
    int updateByPrimaryKeySelective(UserEntity userEntity);
    List<UserEntity> selectUserInfo(UserEntity userEntity);


}
