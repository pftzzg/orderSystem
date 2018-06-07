package com.wutong.user.mapper;

import com.wutong.user.beans.UserInfo;
import com.wutong.user.modle.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * Created by zzg on 2018/6/2.
 */
@Mapper

public interface UserMapper {


    @Select("select id,username, password, real_name as realName," +
            "mobile, email from t_user where id=#{id} limit 1")
      UserInfo getUserById(@Param("id") int id);

    @Select("select id,username, password, real_name as realName," +
            "mobile, email from t_user where username=#{username } limit 1")
      UserInfo getUserByName(@Param("username") String username);


    @Insert("insert into t_user (username, password, real_name, mobile, email)" +
            "values (#{u.username}, #{u.password}, #{u.realName}, #{u.mobile}, #{u.email})")
    int registerUser(@Param("u") UserInfo userInfo);

}
