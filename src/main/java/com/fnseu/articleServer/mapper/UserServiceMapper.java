package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:32
 */
@Mapper
public interface UserServiceMapper {

    @Results(value = {
            @Result(id = true,property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name")
    })
    @Select("select * from user where user_id=#{0}")
    User selById(int id);
}
