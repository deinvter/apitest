package com.mine.api.mapper;


import com.mine.api.entity.DeleteUserCases;

public interface DeleteUserCasesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeleteUserCases record);

    int insertSelective(DeleteUserCases record);

    DeleteUserCases selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeleteUserCases record);

    int updateByPrimaryKey(DeleteUserCases record);
}