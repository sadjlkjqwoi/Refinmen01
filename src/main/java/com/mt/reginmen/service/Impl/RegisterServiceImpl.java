package com.mt.reginmen.service.Impl;

import com.mt.reginmen.dao.LoginMapper;
import com.mt.reginmen.domain.Label;
import com.mt.reginmen.domain.User;
import com.mt.reginmen.dao.RegisterMapper;
import com.mt.reginmen.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public String register(User user) {

        if (loginMapper.findById(user.getId()) != null)
            return "该用户已存在，注册失败";
        else {

            if (registerMapper.register(user.getId(), user.getPassword(), user.getSex(), user.getAge(), user.getPhone()))
                return "注册成功";
            else
                return "注册失败";
        }
    }

    /**
     * 展示所有标签
     *
     * @return
     */
    @Override
    public List<Label> showAllLabels() {
        return registerMapper.showAllLabels();
    }

    /**
     * 获取用户选择的标签
     *
     * @param id
     * @param labels_ids
     * @return
     */
    @Override
    public boolean getSelectLabel(String id, String labels_ids) {
        registerMapper.getSelectLabel(id, labels_ids);
        return true;
    }

    @Override
    public List<Integer> AgeCount() {
        float a = registerMapper.AgeCount(16,44);
        float b = registerMapper.AgeCount(45,59);
        float c = registerMapper.AgeCount(60,999);
        float n = a+b+c;
        int a1 = (int) ((a/n)*100);
        int b1 = (int) ((b/n)*100);
        int c1 = (int) ((c/n)*100);
        List<Integer> list = new ArrayList<>();
        list.add(a1);
        list.add(b1);
        list.add(c1);
        return list;
    }

}
