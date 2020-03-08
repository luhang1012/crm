package com.shsxt.crm.service;

import com.shsxt.crm.dao.UserMapper;
import com.shsxt.crm.model.UserInfo;
import com.shsxt.crm.po.User;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.Md5Util;
import com.shsxt.crm.utils.UserIDBase64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 15625 on 2020/1/26.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    public UserInfo login(String userName, String userPwd){
        //1、参数校验
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名为空");
        AssertUtil.isTrue(StringUtils.isBlank(userPwd),"密码为空");
        User user = userMapper.queryUserByName(userName);
        AssertUtil.isTrue(null==user,"用户不存在");
        //密码进行加密（只能加密，不能解密）
        String encodeUserPwd = Md5Util.encode(userPwd);
        AssertUtil.isTrue(!encodeUserPwd.equals(user.getUserPwd()),"用户或密码错误");
        //获取用户ID并进行加密
        String encoderUserID = UserIDBase64.encoderUserID(user.getId());
        UserInfo Info = new UserInfo(encoderUserID);
        return Info;
    }

    /**
     * 修改密码
     * @param oldPwd
     * @param newPwd
     * @param confirmPwd
     * @param id
     */
    public void updateUserPwd(String oldPwd,String newPwd,String confirmPwd,Integer id){
        //1、参数校验
        checkParams(oldPwd,newPwd,confirmPwd);
        //验证旧密码是否正确
        User user = userMapper.queryUserById(id);
        AssertUtil.isTrue(null==user,"用户不存在");
        //密码进行加密（只能加密，不能解密）
        String encodeUserPwd = Md5Util.encode(oldPwd);
        AssertUtil.isTrue(!encodeUserPwd.equals(user.getUserPwd()),"原密码不正确");
        //密码进行加密（只能加密，不能解密）
        String encodeNewPwd = Md5Util.encode(newPwd);
        //修改密码(修改成功，影响条数大于等于1)
        AssertUtil.isTrue(userMapper.updateUserPwd(id,encodeNewPwd)<1,"密码更新失败");
    }
    //修改密码参数校验
    private void checkParams(String oldPwd,String newPwd,String confirmPwd) {
        AssertUtil.isTrue(StringUtils.isBlank(oldPwd),"原密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(newPwd),"新密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(confirmPwd),"确认密码为空");
        AssertUtil.isTrue(!newPwd.equals(confirmPwd),"两次输入密码不一致");
    }
    //通过ID查询是否存在用户
    public User queryUserById(Integer id){
        User user = userMapper.queryUserById(id);
        return user;
    }
    //查询客户经理
    public List<Map> queryCustomerManagers(){
        //查询可分配人员（客户经理）
        List<Map> maps = userMapper.queryCustomerManagers();
        return maps;
    }
}
