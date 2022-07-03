package com.xb.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserQueryParam {
    private Long id;
    private String name;
    private Integer pageNum;
    private Integer pageSize;
}
