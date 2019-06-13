package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:03
 */
public class AuthFile {
    private Long id;                  //认证标识--->查询入口
    private String enterpriseName;         //企业/机构名称
    private String enterpriseId;           //营业执照编号
    private String licencePicture;         //营业执照照片url
    private String internetLicencePicture;//互联网服务许可证图片url

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLicencePicture() {
        return licencePicture;
    }

    public void setLicencePicture(String licencePicture) {
        this.licencePicture = licencePicture;
    }

    public String getInternetLicencePicture() {
        return internetLicencePicture;
    }

    public void setInternetLicencePicture(String internetLicencePicture) {
        this.internetLicencePicture = internetLicencePicture;
    }
}
