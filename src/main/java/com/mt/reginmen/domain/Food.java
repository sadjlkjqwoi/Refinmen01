package com.mt.reginmen.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)
public class Food {
    private String id;
    private String name;
    private String labels_ids;
    private String vp;
    private String acticle;

}
