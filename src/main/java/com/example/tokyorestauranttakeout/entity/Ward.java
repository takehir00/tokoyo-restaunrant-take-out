package com.example.tokyorestauranttakeout.entity;

import java.util.Date;

public class Ward {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.id
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.name
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.image
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.mime_type
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private String mimeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.created_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward.updated_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.id
     *
     * @return the value of ward.id
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.id
     *
     * @param id the value for ward.id
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.name
     *
     * @return the value of ward.name
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.name
     *
     * @param name the value for ward.name
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.image
     *
     * @return the value of ward.image
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.image
     *
     * @param image the value for ward.image
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.mime_type
     *
     * @return the value of ward.mime_type
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.mime_type
     *
     * @param mimeType the value for ward.mime_type
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType == null ? null : mimeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.created_at
     *
     * @return the value of ward.created_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.created_at
     *
     * @param createdAt the value for ward.created_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward.updated_at
     *
     * @return the value of ward.updated_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward.updated_at
     *
     * @param updatedAt the value for ward.updated_at
     *
     * @mbg.generated Sun Jun 21 20:58:25 JST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}