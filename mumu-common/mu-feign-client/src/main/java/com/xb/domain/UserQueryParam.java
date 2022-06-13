package com.xb.domain;

import lombok.Data;

@Data
public class UserQueryParam {
    private Long id;
    private String name;
    private Integer pageNum;
    private Integer pageSize;
}
