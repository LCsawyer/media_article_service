package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.User;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:32
 * sql语句负责拿到数据，映射负责名字转换，到底Java类赋值多少取决于Java类中属性的数量
 */
@Mapper
public interface UserServiceMapper {
//根据编号查询
    @Results(value = {
    @Result(id = true,property = "userId",column = "id"),
    @Result(property = "userName",column = "real_name")//property是ide中的名字，后面是mysql中的的列名
    })
    @Select("select * from user where id=#{0}")
    User selById(int id);//业务逻辑层的接口

//根据id查询用户   子查询<---功能1：身份审核申请列表
    @Results({
            @Result(column="id",property="userId",id=true),
            @Result(column="real_name",property="userName"),
            })
    @Select(" SELECT * FROM user WHERE id=#{userId};")//可以筛选显示的内容
    public User selectescById(int userId);//以java类为中心，来返回


//功能1：身份审核申请列表
//    @Results(value = {
//
//            @Result(id = true,property = "certificateId",column = "id"),//认证材料Id
//            @Result(property = "role",column = "type"),//认证类型
//            @Result(property = "create_time",column = "create_time"),//提交时间
//            @Result(property = "user",column = "user_id",one = @One(select = "com.fnseu.articleServer.mapper.UserServiceMapper.selectescById",fetchType= FetchType.EAGER))
//    })//一对一的column项1：子查询的形参 2 逻辑上的两个表关联的桥梁，从数据库中查询id丢给后面的查询语句，但绘制为user即是property
//    @Select("SELECT * FROM authentication")//数据首先要查出来，然后是映射对
//    List<Authentication> selAuthticationList();//业务逻辑层的接口

    /**
     * 功能1
     * /review/identity/collection
     * 某个审核人员的某个状态的列表
     *分页sql 输入审核id、状态码、一页容量、当前页数
     */

    //功能1：身份审核申请列表
    @Results(value = {
            @Result(id = true,property = "certificateId",column = "id"),//认证材料Id
            @Result(property = "role",column = "type"),//认证类型
            @Result(property = "description",column = "description"),
            @Result(property = "role",column = "role"),
            @Result(property = "field",column = "field"),
            @Result(property = "create_time",column = "create_time"),//提交时间
            @Result(property = "operator_name",column = "operator_name"),//运营者姓名
    })//一对一的column项1：子查询的形参 2 逻辑上的两个表关联的桥梁，从数据库中查询id丢给后面的查询语句，但绘制为user即是property
    @Select("SELECT * FROM authentication WHERE reviewer_id = #{reviewer_id} AND STATUS =#{STATUS} limit #{offset},#{capacity};")//数据首先要查出来，然后是映射对
    List<Authentication> selAuthticationList(BigInteger reviewer_id, Integer STATUS,Integer capacity, Integer offset);//业务逻辑层的接口

    /**
     * 功能2
     * /review/identity/id
     * 审核材料查询
     * 根据审核材料的id查询
     */
    @Results({
            @Result(column="id",property="certificateId",id=true),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "description",column = "description"),
            @Result(property = "role",column = "role"),
            @Result(property = "field",column = "field"),
            @Result(property = "head_portrait",column = "head_portrait"),
            @Result(property = "operator_name",column = "operator_name"),
            @Result(property = "id_number",column = "id_number"),
            @Result(property = "enterprise_name",column = "enterprise_name"),
            @Result(property = "enterprise_id",column = "enterprise_id"),
            @Result(property = "license_picture",column = "license_picture"),
            @Result(property = "internet_license_picture",column = "internet_license_picture"),
    })
    @Select(" SELECT * FROM authentication where id = #{userId}")//可以筛选显示的内容
    public Authentication selectAuthFileById(int userId);


    /**
     * 功能3
     * /review/identity
     * 用户提交审核
     * 根据审核材料的id查询
     */
    @Insert("insert into authentication(user_id,name) values(#{user_id},#{name})")
    public int insertAuth(Authentication authentication);
}
