package com.mt.reginmen.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)
public class Data {
    private int id;
    private String name;
    private int count;
    private String labels_ids;
    private String reviews_ids;
    private String vp;
    private String acticle;


}
