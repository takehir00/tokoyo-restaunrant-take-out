package com.example.tokyorestauranttakeout.entity;

import java.time.LocalDateTime;

public class Menu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.price
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String mimeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.restaurant_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer restaurantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.priority
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private Integer priority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private LocalDateTime updatedAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    private String image;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.id
     *
     * @return the value of menu.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.id
     *
     * @param id the value for menu.id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.name
     *
     * @return the value of menu.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.name
     *
     * @param name the value for menu.name
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.price
     *
     * @return the value of menu.price
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.price
     *
     * @param price the value for menu.price
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.mime_type
     *
     * @return the value of menu.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.mime_type
     *
     * @param mimeType the value for menu.mime_type
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType == null ? null : mimeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.restaurant_id
     *
     * @return the value of menu.restaurant_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getRestaurantId() {
        return restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.restaurant_id
     *
     * @param restaurantId the value for menu.restaurant_id
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.priority
     *
     * @return the value of menu.priority
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.priority
     *
     * @param priority the value for menu.priority
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.created_at
     *
     * @return the value of menu.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.created_at
     *
     * @param createdAt the value for menu.created_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.updated_at
     *
     * @return the value of menu.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.updated_at
     *
     * @param updatedAt the value for menu.updated_at
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.image
     *
     * @return the value of menu.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.image
     *
     * @param image the value for menu.image
     *
     * @mbg.generated Thu Jun 10 06:40:33 JST 2021
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}