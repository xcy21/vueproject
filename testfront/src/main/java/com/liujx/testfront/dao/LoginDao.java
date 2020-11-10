package com.liujx.testfront.dao;

import com.liujx.testfront.entity.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    Login selectByUsername(String username);

    int selectCountByUsername(String username);
}