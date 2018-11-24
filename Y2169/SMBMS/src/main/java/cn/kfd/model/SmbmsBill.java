package cn.kfd.model;

import java.util.Date;

/**
 * smbms_bill entity
 *
 * @author Happy
 * @date2018-11-02 08:22
 */

public class SmbmsBill {
    /**
     * 主键ID
     **/
    private Long id;
    /**
     * 账单编码
     **/
    private String billCode;
    /**
     * 商品名称
     **/
    private String productName;
    /**
     * 商品描述
     **/
    private String productDesc;
    /**
     * 商品单位
     **/
    private String productUnit;
    /**
     * 商品数量
     **/
    private Double productCount;
    /**
     * 商品总额
     **/
    private Double totalPrice;
    /**
     * 是否支付（1：未支付 2：已支付）
     **/
    private Integer isPayment;
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
     * 供应商ID
     **/
    private Long providerId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public Integer getIsPayment() {
        return isPayment;
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

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getProviderId() {
        return providerId;
    }
}

