package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.WardArea;
import com.example.tokyorestauranttakeout.entity.WardAreaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WardAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    long countByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int deleteByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int insert(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int insertSelective(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    List<WardArea> selectByExampleWithBLOBs(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    List<WardArea> selectByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    WardArea selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByExampleSelective(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByExample(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByPrimaryKeySelective(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByPrimaryKeyWithBLOBs(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 25 18:42:07 JST 2020
     */
    int updateByPrimaryKey(WardArea record);
}