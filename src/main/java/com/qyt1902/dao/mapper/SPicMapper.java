package com.qyt1902.dao.mapper;

import com.qyt1902.entity.SPic;
import com.qyt1902.entity.SPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SPicMapper {
    long countByExample(SPicExample example);

    int deleteByExample(SPicExample example);

    int insert(SPic record);

    int insertSelective(SPic record);

    List<SPic> selectByExample(SPicExample example);

    int updateByExampleSelective(@Param("record") SPic record, @Param("example") SPicExample example);

    int updateByExample(@Param("record") SPic record, @Param("example") SPicExample example);
}