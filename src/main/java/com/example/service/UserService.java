package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.UserEntityMapper;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

//列表
    public List<UserEntity>queryUserList(UserEntity userEntity){
        List<UserEntity> resultt = userEntityMapper.queryUserList(userEntity);
        return resultt;
    }
//新增
    public int addUserInfo(UserEntity userEntity){
        userEntity.setId(UUIDUtil.getUUID());
        int userResult = userEntityMapper.insert(userEntity);
        if (userResult != 0) {
            return 3;
        } else {
            return userResult;
        }
    }
//修改
    public int updateByPrimaryKeySelective(UserEntity userEntity) {
        int userchange = userEntityMapper.updateByPrimaryKeySelective(userEntity);
        return userchange;
    }
//删除
    public int deleteUserByName(UserEntity userEntity){
        int userResult = userEntityMapper.deleteUserByName(userEntity);
        return userResult;
    }

    public List<UserEntity> selectUserInfo(UserEntity userEntity) {
        List<UserEntity> result = userEntityMapper.selectUserInfo(userEntity);
        return result;
    }

}
