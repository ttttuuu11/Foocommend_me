package com.school.foocommend.member.vo;

import lombok.Data;


@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String isadmin;
}
