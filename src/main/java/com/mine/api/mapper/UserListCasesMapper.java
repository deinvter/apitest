package com.mine.api.mapper;


import com.mine.api.entity.UserListCases;

public interface UserListCasesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserListCases record);

    int insertSelective(UserListCases record);

    UserListCases selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserListCases record);

    int updateByPrimaryKey(UserListCases record);
}