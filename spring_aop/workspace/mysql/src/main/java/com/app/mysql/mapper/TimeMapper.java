package com.app.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
//    현재 시간
    public String getTime();
}
