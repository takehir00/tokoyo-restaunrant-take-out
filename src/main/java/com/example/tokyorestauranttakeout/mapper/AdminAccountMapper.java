package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.AdminAccount;
import com.example.tokyorestauranttakeout.entity.AdminAccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    long countByExample(AdminAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int deleteByExample(AdminAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int insert(AdminAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int insertSelective(AdminAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    List<AdminAccount> selectByExample(AdminAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    AdminAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int updateByExampleSelective(@Param("record") AdminAccount record, @Param("example") AdminAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int updateByExample(@Param("record") AdminAccount record, @Param("example") AdminAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int updateByPrimaryKeySelective(AdminAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_account
     *
     * @mbg.generated Sun May 02 19:57:30 JST 2021
     */
    int updateByPrimaryKey(AdminAccount record);
}