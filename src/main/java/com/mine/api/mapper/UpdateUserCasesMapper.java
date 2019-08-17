package com.mine.api.mapper;


import com.mine.api.entity.UpdateUserCases;

public interface UpdateUserCasesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UpdateUserCases record);

    int insertSelective(UpdateUserCases record);

    UpdateUserCases selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UpdateUserCases record);

    int updateByPrimaryKey(UpdateUserCases record);
}