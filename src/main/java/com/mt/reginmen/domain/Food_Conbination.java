package com.mt.reginmen.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(autoResultMap = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food_Conbination {
    private String id;
    private String name;
    private String labels_ids;
    private String vp;
    private String acticle;


}
