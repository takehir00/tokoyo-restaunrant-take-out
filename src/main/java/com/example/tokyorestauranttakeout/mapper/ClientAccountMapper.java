package com.example.tokyorestauranttakeout.mapper;

import com.example.tokyorestauranttakeout.entity.ClientAccount;
import com.example.tokyorestauranttakeout.entity.ClientAccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ClientAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    long countByExample(ClientAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int deleteByExample(ClientAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int insert(ClientAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int insertSelective(ClientAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    List<ClientAccount> selectByExample(ClientAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    ClientAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int updateByExampleSelective(@Param("record") ClientAccount record, @Param("example") ClientAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int updateByExample(@Param("record") ClientAccount record, @Param("example") ClientAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int updateByPrimaryKeySelective(ClientAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_account
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    int updateByPrimaryKey(ClientAccount record);
}