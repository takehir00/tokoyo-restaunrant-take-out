package com.example.tokyorestauranttakeout.entity;

import java.util.Date;

public class Restaurant {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.name
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.address
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.phone_number
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.mime_type
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String mimeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.introduction
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.genre_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Integer genreId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.from_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String fromTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.to_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String toTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.ward_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Integer wardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.ward_area_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Integer wardAreaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.created_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.updated_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private Date updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.image
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    private String image;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.id
     *
     * @return the value of restaurant.id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.id
     *
     * @param id the value for restaurant.id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.name
     *
     * @return the value of restaurant.name
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.name
     *
     * @param name the value for restaurant.name
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.address
     *
     * @return the value of restaurant.address
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.address
     *
     * @param address the value for restaurant.address
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.phone_number
     *
     * @return the value of restaurant.phone_number
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.phone_number
     *
     * @param phoneNumber the value for restaurant.phone_number
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.mime_type
     *
     * @return the value of restaurant.mime_type
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.mime_type
     *
     * @param mimeType the value for restaurant.mime_type
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType == null ? null : mimeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.introduction
     *
     * @return the value of restaurant.introduction
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.introduction
     *
     * @param introduction the value for restaurant.introduction
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.genre_id
     *
     * @return the value of restaurant.genre_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Integer getGenreId() {
        return genreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.genre_id
     *
     * @param genreId the value for restaurant.genre_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.from_time
     *
     * @return the value of restaurant.from_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.from_time
     *
     * @param fromTime the value for restaurant.from_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime == null ? null : fromTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.to_time
     *
     * @return the value of restaurant.to_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.to_time
     *
     * @param toTime the value for restaurant.to_time
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setToTime(String toTime) {
        this.toTime = toTime == null ? null : toTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.ward_id
     *
     * @return the value of restaurant.ward_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Integer getWardId() {
        return wardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.ward_id
     *
     * @param wardId the value for restaurant.ward_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.ward_area_id
     *
     * @return the value of restaurant.ward_area_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Integer getWardAreaId() {
        return wardAreaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.ward_area_id
     *
     * @param wardAreaId the value for restaurant.ward_area_id
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setWardAreaId(Integer wardAreaId) {
        this.wardAreaId = wardAreaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.created_at
     *
     * @return the value of restaurant.created_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.created_at
     *
     * @param createdAt the value for restaurant.created_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.updated_at
     *
     * @return the value of restaurant.updated_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.updated_at
     *
     * @param updatedAt the value for restaurant.updated_at
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.image
     *
     * @return the value of restaurant.image
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.image
     *
     * @param image the value for restaurant.image
     *
     * @mbg.generated Sat Aug 08 09:26:04 JST 2020
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}