package com.example.tokyorestauranttakeout.entity;

import java.time.LocalDateTime;

public class ClientAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.id
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.email
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.password
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.name
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.image_url
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.created_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private LocalDateTime createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_account.updated_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    private LocalDateTime updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.id
     *
     * @return the value of client_account.id
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.id
     *
     * @param id the value for client_account.id
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.email
     *
     * @return the value of client_account.email
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.email
     *
     * @param email the value for client_account.email
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.password
     *
     * @return the value of client_account.password
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.password
     *
     * @param password the value for client_account.password
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.name
     *
     * @return the value of client_account.name
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.name
     *
     * @param name the value for client_account.name
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.image_url
     *
     * @return the value of client_account.image_url
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.image_url
     *
     * @param imageUrl the value for client_account.image_url
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.created_at
     *
     * @return the value of client_account.created_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.created_at
     *
     * @param createdAt the value for client_account.created_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_account.updated_at
     *
     * @return the value of client_account.updated_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_account.updated_at
     *
     * @param updatedAt the value for client_account.updated_at
     *
     * @mbg.generated Thu Jun 10 07:24:59 JST 2021
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}