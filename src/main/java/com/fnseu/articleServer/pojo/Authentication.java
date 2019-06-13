package com.fnseu.articleServer.pojo;

import java.sql.Timestamp;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:05
 */
public class Authentication {
    private Long certificateId;       //认证标识
    private Long userId;             //用户标识
    private String name;                    //媒体名称
    private String description;             //媒体描述
    private int role;                       //媒体类型
    private int field;                      //媒体领域
    private String headPortrait;           //机构头像
    private String operatorName;           //运营者姓名
    private String idNumber;               //运营者身份证号
    private String enterpriseName;         //企业/机构名称
    private String enterpriseId;           //营业执照编号
    private String licensePicture;         //营业执照照片url
    private String internetLicensePicture;//互联网服务许可证图片url
    private Timestamp createTime;          //创建时间
    private Timestamp updateTime;          //更新时间
    private Timestamp reviewTime;          //审核时间
    private Long reviewerId;         //审核人员
    private String reviewDescription;      //审核意见
    private int status;                     //状态
    private User user;

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLicensePicture() {
        return licensePicture;
    }

    public void setLicensePicture(String licensePicture) {
        this.licensePicture = licensePicture;
    }

    public String getInternetLicensePicture() {
        return internetLicensePicture;
    }

    public void setInternetLicensePicture(String internetLicensePicture) {
        this.internetLicensePicture = internetLicensePicture;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
