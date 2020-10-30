package com.jiajunliang.ssm.simpleblog.dao;

import com.jiajunliang.ssm.simpleblog.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryByUsername(@Param("userName") String username);

    User queryByUsernameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(@Param("userId") int userId);

}
