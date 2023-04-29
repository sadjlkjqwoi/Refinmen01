package com.mt.reginmen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews_topics {
    private int id;
    private String user_id;
    private int topics_id;
    private String content;


}
