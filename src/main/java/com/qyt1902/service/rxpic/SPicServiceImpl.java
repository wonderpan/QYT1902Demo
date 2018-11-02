package com.qyt1902.service.rxpic;

import com.qyt1902.dao.mapper.SPicMapper;
import com.qyt1902.entity.SPic;
import com.qyt1902.entity.SPicExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SPicServiceImpl  implements SPicService{
    @Autowired
    private SPicMapper mapper;
    public long countByExample(SPicExample example) {
        return mapper.countByExample(example);
    }

    public int deleteByExample(SPicExample example) {
        return mapper.deleteByExample(example);
    }

    public int insert(SPic record) {
        return mapper.insert(record);
    }

    public int insertSelective(SPic record) {
        return mapper.insertSelective(record);
    }

    public List<SPic> selectByExample(SPicExample example) {
        return mapper.selectByExample(example);
    }

    public int updateByExampleSelective(SPic record, SPicExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(SPic record, SPicExample example) {
        return mapper.updateByExample(record, example);
    }
}
