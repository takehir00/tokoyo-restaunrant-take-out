package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.model.Menu;
import com.example.tokyorestauranttakeout.model.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    long countByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    int deleteByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Thu Jun 04 08:01:20 JST 2020
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);
}