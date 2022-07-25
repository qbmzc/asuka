package com.cong.asukaservice.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试
 */
@Data
public class Test  implements Serializable {

    private String name;

    private String url;

    private Integer age;
}
