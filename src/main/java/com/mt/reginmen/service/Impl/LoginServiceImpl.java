package com.mt.reginmen.service.Impl;


import com.mt.reginmen.dao.LoginMapper;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public String login(String id, String password) {

        User user = loginMapper.findById(id);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "登录成功，欢迎您！";
            } else {
                return "登录失败，密码错误";
            }
        } else {
            return "登录失败，该用户不存在";
        }


    }
}
