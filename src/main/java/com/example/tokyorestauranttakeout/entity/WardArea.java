package com.example.tokyorestauranttakeout.entity;

import java.time.LocalDateTime;

public class WardArea {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String mimeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.ward_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer wardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ward_area.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String image;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.id
     *
     * @return the value of ward_area.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.id
     *
     * @param id the value for ward_area.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.name
     *
     * @return the value of ward_area.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.name
     *
     * @param name the value for ward_area.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.mime_type
     *
     * @return the value of ward_area.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.mime_type
     *
     * @param mimeType the value for ward_area.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType == null ? null : mimeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.ward_id
     *
     * @return the value of ward_area.ward_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.ward_id
     *
     * @param wardId the value for ward_area.ward_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.created_at
     *
     * @return the value of ward_area.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.created_at
     *
     * @param createdAt the value for ward_area.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.updated_at
     *
     * @return the value of ward_area.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.updated_at
     *
     * @param updatedAt the value for ward_area.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ward_area.image
     *
     * @return the value of ward_area.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ward_area.image
     *
     * @param image the value for ward_area.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}