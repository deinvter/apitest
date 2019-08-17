package com.mine.api.mapper;


import com.mine.api.entity.AddUserCases;
import org.apache.ibatis.annotations.Param;

public interface AddUserCasesMapper {


    AddUserCases selectById(@Param("id") Long id);

}