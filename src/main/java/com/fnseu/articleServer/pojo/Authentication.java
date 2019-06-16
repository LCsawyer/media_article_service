package com.fnseu.articleServer.pojo;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Authentication {
    private BigInteger certificateId;       //认证标识
    private BigInteger user_id;             //用户标识
    private String name;                    //媒体名称
    private String description;             //媒体描述
    private int role;                       //媒体类型
    private int field;                      //媒体领域
    private String head_portrait;           //机构头像
    private String operator_name;           //运营者姓名
    private String id_number;               //运营者身份证号
    private String enterprise_name;         //企业/机构名称
    private String enterprise_id;           //营业执照编号
    private String license_picture;         //营业执照照片url
    private String internet_license_picture;//互联网服务许可证图片url
    private Timestamp create_time;          //创建时间
    private Timestamp update_time;          //更新时间
    private Timestamp review_time;          //审核时间
    private BigInteger reviewer_id;         //审核人员
    private String review_description;      //审核意见
    private int status;                     //状态
    private User user;

    public Authentication() {}

    public Authentication(BigInteger certificateId, BigInteger user_id, String name, String description, int role, int field, String head_portrait, String operator_name, String id_number, String enterprise_name, String enterprise_id, String license_picture, String internet_license_picture, Timestamp create_time, Timestamp update_time, Timestamp review_time, BigInteger reviewer_id, String review_description, int status, User user) {
        this.certificateId = certificateId;
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.role = role;
        this.field = field;
        this.head_portrait = head_portrait;
        this.operator_name = operator_name;
        this.id_number = id_number;
        this.enterprise_name = enterprise_name;
        this.enterprise_id = enterprise_id;
        this.license_picture = license_picture;
        this.internet_license_picture = internet_license_picture;
        this.create_time = create_time;
        this.update_time = update_time;
        this.review_time = review_time;
        this.reviewer_id = reviewer_id;
        this.review_description = review_description;
        this.status = status;
        this.user = user;
    }

    public BigInteger getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(BigInteger certificateId) {
        this.certificateId = certificateId;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
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

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getLicense_picture() {
        return license_picture;
    }

    public void setLicense_picture(String license_picture) {
        this.license_picture = license_picture;
    }

    public String getInternet_license_picture() {
        return internet_license_picture;
    }

    public void setInternet_license_picture(String internet_license_picture) {
        this.internet_license_picture = internet_license_picture;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Timestamp getReview_time() {
        return review_time;
    }

    public void setReview_time(Timestamp review_time) {
        this.review_time = review_time;
    }

    public BigInteger getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(BigInteger reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public String getReview_description() {
        return review_description;
    }

    public void setReview_description(String review_description) {
        this.review_description = review_description;
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

    @Override
    public String toString() {
        return "Authentication{" +
                "certificateId=" + certificateId +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", field=" + field +
                ", head_portrait='" + head_portrait + '\'' +
                ", operator_name='" + operator_name + '\'' +
                ", id_number='" + id_number + '\'' +
                ", enterprise_name='" + enterprise_name + '\'' +
                ", enterprise_id='" + enterprise_id + '\'' +
                ", license_picture='" + license_picture + '\'' +
                ", internet_license_picture='" + internet_license_picture + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", review_time=" + review_time +
                ", reviewer_id=" + reviewer_id +
                ", review_description='" + review_description + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
