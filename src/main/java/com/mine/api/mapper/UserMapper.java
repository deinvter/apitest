package com.mine.api.mapper;


import com.mine.api.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectByName(@Param("name") String name);
}