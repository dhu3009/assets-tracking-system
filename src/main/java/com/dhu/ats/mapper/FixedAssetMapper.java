package com.dhu.ats.mapper;

import com.dhu.ats.model.FixedAsset;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FixedAssetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer assetId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    int insert(FixedAsset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    int insertSelective(FixedAsset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    FixedAsset selectByPrimaryKey(Integer assetId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FixedAsset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fixed_asset
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FixedAsset record);
    List<FixedAsset> getFixedAssetBySmallClassId(int smallClassId);

    int deleteFixedAssetBySmallClassId(int smallClassId);

    List<FixedAsset> getFixedAssetByLargeClassId(int largeClassId);

    List<FixedAsset> getAllFixedAsset();

//    List<FixedAsset> getOrderedFixedAssetByLargeClassId(@Param("largeClassId") int largeClassId,@Param("field") String field,@Param("order") String order);
}