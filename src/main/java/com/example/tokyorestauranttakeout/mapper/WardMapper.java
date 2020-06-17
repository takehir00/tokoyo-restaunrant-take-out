package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.Ward;
import com.example.tokyorestauranttakeout.entity.WardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    long countByExample(WardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int deleteByExample(WardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int insert(Ward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int insertSelective(Ward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    List<Ward> selectByExample(WardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    Ward selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int updateByExampleSelective(@Param("record") Ward record, @Param("example") WardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int updateByExample(@Param("record") Ward record, @Param("example") WardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int updateByPrimaryKeySelective(Ward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward
     *
     * @mbg.generated Mon Jun 15 22:20:40 JST 2020
     */
    int updateByPrimaryKey(Ward record);
}