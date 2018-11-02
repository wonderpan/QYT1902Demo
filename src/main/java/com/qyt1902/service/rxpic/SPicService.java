package com.qyt1902.service.rxpic;

import com.qyt1902.entity.SPic;
import com.qyt1902.entity.SPicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SPicService {
    long countByExample(SPicExample example);

    int deleteByExample(SPicExample example);

    int insert(SPic record);

    int insertSelective(SPic record);

    List<SPic> selectByExample(SPicExample example);

    int updateByExampleSelective(@Param("record") SPic record, @Param("example") SPicExample example);

    int updateByExample(@Param("record") SPic record, @Param("example") SPicExample example);
}
