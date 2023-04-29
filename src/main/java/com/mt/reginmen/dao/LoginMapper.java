package com.mt.reginmen.dao;

import com.mt.reginmen.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LoginMapper {

    User findById(String id);


}
