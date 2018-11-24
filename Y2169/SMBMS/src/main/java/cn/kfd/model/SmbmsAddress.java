package cn.kfd.model;

import java.util.Date;

/**
 * smbms_address entity
 *
 * @author Happy
 * @date2018-11-02 08:22
 */

public class SmbmsAddress {
    /**
     * 主键ID
     **/
    private Long id;
    /**
     * 联系人姓名
     **/
    private String contact;
    /**
     * 收货地址明细
     **/
    private String addressDesc;
    /**
     * 邮编
     **/
    private String postCode;
    /**
     * 联系人电话
     **/
    private String tel;
    /**
     * 创建者
     **/
    private Long createdBy;
    /**
     * 创建时间
     **/
    private Date creationDate;
    /**
     * 修改者
     **/
    private Long modifyBy;
    /**
     * 修改时间
     **/
    private Date modifyDate;
    /**
     * 用户ID
     **/
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}

