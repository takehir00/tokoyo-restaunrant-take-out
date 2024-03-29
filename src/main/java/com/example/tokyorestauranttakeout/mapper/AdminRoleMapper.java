package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.AdminRole;
import com.example.tokyorestauranttakeout.entity.AdminRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    long countByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insert(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int insertSelective(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    List<AdminRole> selectByExample(AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    AdminRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKeySelective(AdminRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_role
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    int updateByPrimaryKey(AdminRole record);
}