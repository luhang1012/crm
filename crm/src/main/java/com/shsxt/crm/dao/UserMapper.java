package com.shsxt.crm.dao;

import com.shsxt.crm.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserMapper {
    public User queryUserByName(String userName);
    public User queryUserById(Integer id);
    public Integer updateUserPwd(@Param("id") Integer id,@Param("userPwd") String userPwd);
    public List<Map> queryCustomerManagers();
}