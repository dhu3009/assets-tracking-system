package com.dhu.ats.service;

import com.dhu.ats.mapper.SmallClassMapper;

import com.dhu.ats.model.LargeClass;
import com.dhu.ats.model.SmallClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmallClassService {
    @Autowired
    public SmallClassMapper smallClassMapper;

    public int createSmallClass(SmallClass smallClass){
        return  smallClassMapper.insert(smallClass);
    }

    public int updateSmallClass(SmallClass smallClass){
        return smallClassMapper.updateByPrimaryKey(smallClass);
    }

    public List<SmallClass> getSmallClassByLargeClassId(int largeClassId){
        return smallClassMapper.getSmallClassByLargeClassId(largeClassId);
    }


    public int checkSmallClassExist(String smallClassName){
        return  smallClassMapper.checkSmallClassExist(smallClassName);
    }

    public int deleteSmallClassById(Integer smallClassId) {
        return smallClassMapper.deleteByPrimaryKey(smallClassId);
    }
}
