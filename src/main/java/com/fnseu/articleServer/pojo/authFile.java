package com.fnseu.articleServer.pojo;

import java.math.BigInteger;

public class authFile {
    private BigInteger id;                  //认证标识--->查询入口
    private String enterprise_name;         //企业/机构名称
    private String enterprise_id;           //营业执照编号
    private String licence_picture;         //营业执照照片url
    private String internet_licence_picture;//互联网服务许可证图片url

    public authFile(BigInteger id, String enterprise_name, String enterprise_id, String licence_picture, String internet_licence_picture) {
        this.id = id;
        this.enterprise_name = enterprise_name;
        this.enterprise_id = enterprise_id;
        this.licence_picture = licence_picture;
        this.internet_licence_picture = internet_licence_picture;
    }

    public authFile() {}

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getLicence_picture() {
        return licence_picture;
    }

    public void setLicence_picture(String licence_picture) {
        this.licence_picture = licence_picture;
    }

    public String getInternet_licence_picture() {
        return internet_licence_picture;
    }

    public void setInternet_licence_picture(String internet_licence_picture) {
        this.internet_licence_picture = internet_licence_picture;
    }
}
