package com.dhu.ats.service;

import com.dhu.ats.mapper.FixedAssetMapper;
import com.dhu.ats.model.FixedAsset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedAssetService {
    @Autowired
    public FixedAssetMapper fixedAssetMapper;
    public List<FixedAsset> getFixedAssetBySmallClassId(int smallClassId){
        return fixedAssetMapper.getFixedAssetBySmallClassId(smallClassId);
    }
    public int createFixedAsset(FixedAsset fixedAsset) {
        return fixedAssetMapper.insertSelective(fixedAsset);
    }
}
