package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterMapper {

    //void register(String user_id, String user_password, String sex, int age, String phone, JsonString label);

    /**
     * 用户注册
     *
     * @param id
     * @param password
     * @param sex
     * @param age
     * @param phone
     * @return
     */
    boolean register(String id, String password, String sex, int age, String phone);

    /**
     * 展示所有标签
     *
     * @return
     */
    List<Label> showAllLabels();

    /**
     * 获取用户选择的标签
     *
     * @param id
     * @param labels_ids
     * @return
     */

    boolean getSelectLabel(String id, String labels_ids);
    public String findUserLabels(String user_id);

    int AgeCount(int min,int max);


}
