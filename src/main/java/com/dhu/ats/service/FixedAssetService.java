package com.dhu.ats.service;

import com.dhu.ats.mapper.FixedAssetMapper;
import com.dhu.ats.model.FixedAsset;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedAssetService {
    @Autowired
    public FixedAssetMapper fixedAssetMapper;

    public List<FixedAsset> getFixedAssetBySmallClassId(int smallClassId) {
        return fixedAssetMapper.getFixedAssetBySmallClassId(smallClassId);
    }

    public int updateFixedAsset(FixedAsset fixedAsset) {
        return fixedAssetMapper.updateByPrimaryKey(fixedAsset);
    }

    public int updateFixedAssetBySelect(FixedAsset fixedAsset) {
        return fixedAssetMapper.updateByPrimaryKeySelective(fixedAsset);
    }

    public int createFixedAsset(FixedAsset fixedAsset) {
        return fixedAssetMapper.insertSelective(fixedAsset);
    }

    public int deleteFixedAssetBySmallClassId(int smallClassId) {
        return fixedAssetMapper.deleteFixedAssetBySmallClassId(smallClassId);
    }

    public int deleteFixedAssetById(int assetId) {
        return fixedAssetMapper.deleteByPrimaryKey(assetId);
    }

    public List<FixedAsset> getFixedAssetByLargeClassId(int largeClassId) {
        return fixedAssetMapper.getFixedAssetByLargeClassId(largeClassId);
    }

    public List<FixedAsset> getAllFixedAsset(
            String largeClassName,
            String smallClassName,
            String assetName,
            String assignDate,
            String state,
            String placeLocation,
            int recentDays) {
        return fixedAssetMapper.getAllFixedAsset(largeClassName,
                smallClassName,
                assetName,
                assignDate,
                state,
                placeLocation,
                recentDays);

    }

//    public List<FixedAsset> getFixedAssetBySelectiveFields(
//            String largeClassName,
//            String smallClassName,
//            String assetName,
//            String assignDate,
//            String state,
//            String placeLocation
//    ) {
//        return fixedAssetMapper.getFixedAssetBySelectiveFields(largeClassName,
//                smallClassName,
//                assetName,
//                assignDate,
//                state,
//                placeLocation);
//    }


//    public List<FixedAsset> getOrderedFixedAssetByLargeClassId(int largeClassId, String field, String order){
//        return fixedAssetMapper.getOrderedFixedAssetByLargeClassId(largeClassId,field,order);
//    }
}
