package com.mt.reginmen.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topics {
    private int id;
    private int count;
    private String name;
    private String content;
    private String reviews_ids;
    private String user_id;
}
