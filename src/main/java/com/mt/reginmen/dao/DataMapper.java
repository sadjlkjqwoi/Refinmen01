package com.mt.reginmen.dao;

import com.mt.reginmen.domain.Data;
import com.mt.reginmen.domain.Reviews_data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {
    /**
     * 获取用户所有的标签id
     *
     * @param id
     * @return
     */
    String getUserLabel(String id);


    List<Data> findDataByLabel(String labels_ids);


    List<Data> findAllData();

    /**
     * 图片视频文章等资源上传
     * @param id
     * @return
     */


    /**
     * 上传数据的评论
     *
     * @param id
     * @return
     */
    Reviews_data findReviewsById(int id);

    /**
     * 根据热度查询
     * @return
     */
    List<Data> findDataByCount();

    /**
     * 点击量增加
     * @param id
     */

    void click(int id);

    List<String> getLabelTop3(int min,int max);

    List<Data> findAllDatas();


}
