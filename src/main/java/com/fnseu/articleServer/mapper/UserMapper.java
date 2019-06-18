package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:32
 */
@Mapper
public interface UserMapper {

    //根据编号查询
    @Results(value = {
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "userName",column = "real_name")//property是ide中的名字，后面是mysql中的的列名
    })
    @Select("select * from user where id=#{0}")
    User selById(Long id);//业务逻辑层的接口


    @Select("select count(*) from authentication where reviewer_id=#{0} and status=#{1}")
    int countAuth(Long reviewer_id,Integer STATUS);

    //功能1：身份审核申请列表
    @Results(value = {
            @Result(id = true,property = "certificateId",column = "id"),//认证材料Id
            @Result(property = "role",column = "type"),//认证类型
            @Result(property = "description",column = "description"),
            @Result(property = "role",column = "role"),
            @Result(property = "field",column = "field"),
            @Result(property = "createTime",column = "create_time"),//提交时间
            @Result(property = "operatorName",column = "operator_name"),//运营者姓名
    })//一对一的column项1：子查询的形参 2 逻辑上的两个表关联的桥梁，从数据库中查询id丢给后面的查询语句，但绘制为user即是property
    @Select("SELECT * FROM authentication WHERE reviewer_id = #{reviewer_id} AND status=#{STATUS} limit #{offset},#{capacity};")//数据首先要查出来，然后是映射对
    List<Authentication> selAuthticationList(Long reviewer_id, Integer STATUS, Integer offset, Integer capacity);//业务逻辑层的接口

    /**
     * 功能2
     * /review/identity/id
     * 审核材料查询
     * 根据审核材料的id查询
     */
    @Results({
            @Result(column="id",property="certificateId",id=true),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "role",column = "role"),
            @Result(property = "field",column = "field"),
            @Result(property = "headPortrait",column = "head_portrait"),
            @Result(property = "operatorName",column = "operator_name"),
            @Result(property = "idNumber",column = "id_number"),
            @Result(property = "enterpriseName",column = "enterprise_name"),
            @Result(property = "enterpriseId",column = "enterprise_id"),
            @Result(property = "licensePicture",column = "license_picture"),
            @Result(property = "internetLicensePicture",column = "internet_license_picture"),
    })
    @Select(" SELECT * FROM authentication where id = #{userId}")//可以筛选显示的内容
    public Authentication selectAuthFileById(Long userId);


    /**
     * 功能3
     * /review/identity
     * 用户提交审核
     * 根据审核材料的id查询
     */
    @Insert("insert into authentication(user_id,name) values(#{user_id},#{name})")
    public int insertAuth(Authentication authentication);
}
