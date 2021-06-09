package com.example.tokyorestauranttakeout.entity;

import java.time.LocalDateTime;

public class Restaurant {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.address
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.phone_number
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String mimeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.introduction
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.genre_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer genreId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.from_time
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String fromTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.to_time
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String toTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.ward_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer wardId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.ward_area_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer wardAreaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column restaurant.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String image;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.id
     *
     * @return the value of restaurant.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.created_at
     *
     * @param createdAt the value for restaurant.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.updated_at
     *
     * @return the value of restaurant.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column restaurant.updated_at
     *
     * @param updatedAt the value for restaurant.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column restaurant.image
     *
     * @return the value of restaurant.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
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
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}