package com.dhu.ats.service;

import com.dhu.ats.mapper.LargeClassMapper;
import com.dhu.ats.model.LargeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LargeClassService {
    @Autowired
    public LargeClassMapper largeClassMapper;

    public int createLargeClass(LargeClass largeClass) {

        return largeClassMapper.insert(largeClass);
    }

    public List<LargeClass> getAllLargeClass() {
        return largeClassMapper.getAllLargeClass();

    }

    public int deleteLargeClassById(int largeClassId) {
        return largeClassMapper.deleteByPrimaryKey(largeClassId);
    }

    public LargeClass getLargeClassById(int largeClassId) {
        return largeClassMapper.selectByPrimaryKey(largeClassId);
    }

    public int updateLargeClass(LargeClass largeClass) {
        return largeClassMapper.updateByPrimaryKey(largeClass);
    }
}
