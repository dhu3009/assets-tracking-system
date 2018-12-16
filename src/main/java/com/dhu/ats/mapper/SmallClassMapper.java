package com.dhu.ats.mapper;

import com.dhu.ats.model.SmallClass;

import java.util.List;

public interface SmallClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer smallClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    int insert(SmallClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    int insertSelective(SmallClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    SmallClass selectByPrimaryKey(Integer smallClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SmallClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table small_class
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SmallClass record);
    List<SmallClass> getSmallClassByLargeClassId(int largeClassId);

    int deleteSmallClassByLargeClassId(int largeClassId);
}