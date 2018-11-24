package cn.kfd.model;

import java.util.Date;

/**
 * smbms_user entity
 *
 * @author Happy
 * @date2018-11-02 08:22
 */

public class SmbmsUser {
    /**
     * 主键ID
     **/
    private Long id;
    /**
     * 用户编码
     **/
    private String userCode;
    /**
     * 用户名称
     **/
    private String userName;
    /**
     * 用户密码
     **/
    private String userPassword;
    /**
     * 性别（1:女、 2:男）
     **/
    private Integer gender;
    /**
     * 出生日期
     **/
    private Date birthday;
    /**
     * 手机
     **/
    private String phone;
    /**
     * 地址
     **/
    private String address;
    /**
     * 用户角色（取自角色表-角色id）
     **/
    private Long userRole;
    /**
     * 创建者（userId）
     **/
    private Long createdBy;
    /**
     * 创建时间
     **/
    private Date creationDate;
    /**
     * 更新者（userId）
     **/
    private Long modifyBy;
    /**
     * 更新时间
     **/
    private Date modifyDate;
    /**
     * 年龄
     */
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    public Long getUserRole() {
        return userRole;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }
}

