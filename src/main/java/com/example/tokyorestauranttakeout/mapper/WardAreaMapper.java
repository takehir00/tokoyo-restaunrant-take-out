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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    long countByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insert(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insertSelective(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    List<WardArea> selectByExampleWithBLOBs(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    List<WardArea> selectByExample(WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    WardArea selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExampleSelective(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExample(@Param("record") WardArea record, @Param("example") WardAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKeySelective(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKeyWithBLOBs(WardArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ward_area
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKey(WardArea record);
}