package com.dhu.ats.mapper;

import com.dhu.ats.model.LargeClass;

import java.util.List;

public interface LargeClassMapper {


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer largeClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    int insert(LargeClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    int insertSelective(LargeClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    LargeClass selectByPrimaryKey(Integer largeClassId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LargeClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table large_class
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LargeClass record);

    List<LargeClass> getAllLargeClass();
}