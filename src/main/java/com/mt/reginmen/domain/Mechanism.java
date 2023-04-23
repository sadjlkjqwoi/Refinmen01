package com.mt.reginmen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mechanism {
    private int id;
    private String name;
    private String address;
    private String content;
    private String phone;
    private String image;

}
