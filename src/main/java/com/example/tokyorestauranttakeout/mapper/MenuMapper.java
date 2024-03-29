package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.Menu;
import com.example.tokyorestauranttakeout.entity.MenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    long countByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    List<Menu> selectByExampleWithBLOBs(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKeyWithBLOBs(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKey(Menu record);
}